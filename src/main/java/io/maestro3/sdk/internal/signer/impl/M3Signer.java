/*
 * Copyright 2023 Maestro Cloud Control LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.maestro3.sdk.internal.signer.impl;

import io.maestro3.sdk.exception.EncryptionException;
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.provider.IM3CredentialsProvider;
import io.maestro3.sdk.internal.signer.IM3Signer;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.M3ApiRequest;
import io.maestro3.sdk.v3.core.M3Credentials;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

public class M3Signer implements IM3Signer {

    private static final String SIGN_ALGORITHM = "HmacSHA256";
    private static final String ENCRYPTION_ALGORITHM = "AES";
    private static final String PROVIDER = "BC";
    private static final int GCM_IV_LENGTH = 12;

    private final ThreadLocal<Mac> hmacSha256;
    private final IM3CredentialsProvider credentialsProvider;
    private final SecureRandom random = new SecureRandom();

    public M3Signer(IM3CredentialsProvider credentialsProvider) {
        this.credentialsProvider = credentialsProvider;
        this.hmacSha256 = ThreadLocal.withInitial(this::initMacInstance);
        Security.addProvider(new BouncyCastleProvider());
    }

    @Override
    public M3ApiRequest sign(M3ApiRequest request, String accessKey) {
        M3Credentials credentials = credentialsProvider.getCredentials(accessKey);
        long date = request.getTimestamp();

        String signature = generateSign(date, credentials, request.getUserIdentifier());

        request.setAccessKey(accessKey);
        request.setSignature(signature);
        return request;
    }

    @Override
    public boolean isSignValid(String sign, long date, String accessKey, String userIdentifier) {
        Assert.hasText(sign, "sign");
        M3Credentials credentials = credentialsProvider.getCredentials(accessKey);
        String expectedSign = generateSign(date, credentials, userIdentifier);
        return sign.equals(expectedSign);
    }

    @Override
    public String encrypt(String dataToEncrypt, String accessKey) {
        M3Credentials credentials = credentialsProvider.getCredentials(accessKey);
        String secretKey = credentials.getSecretKey();
        byte[] iv = new byte[GCM_IV_LENGTH]; //NEVER REUSE THIS IV WITH SAME KEY
        random.nextBytes(iv);
        byte[] cipherText;
        try {
            Cipher cipher = initCipher(Cipher.ENCRYPT_MODE, secretKey, iv);
            cipherText = cipher.doFinal(dataToEncrypt.getBytes(StandardCharsets.UTF_8));
        } catch (Exception ex) {
            throw new EncryptionException("Problems during encrypting data", ex);
        }

        ByteBuffer byteBuffer = ByteBuffer.allocate(iv.length + cipherText.length);
        byteBuffer.put(iv);
        byteBuffer.put(cipherText);
        return Base64.getEncoder().encodeToString(byteBuffer.array()).trim();
    }

    @Override
    public String decrypt(String dataToDecrypt, String accessKey) {
        M3Credentials credentials = credentialsProvider.getCredentials(accessKey);
        String secretKey = credentials.getSecretKey();
        try {
            byte[] cipherMessage = Base64.getDecoder().decode(dataToDecrypt);
            Cipher cipher = initCipher(Cipher.DECRYPT_MODE, secretKey, cipherMessage);
            byte[] plainText = cipher.doFinal(cipherMessage, GCM_IV_LENGTH, cipherMessage.length - GCM_IV_LENGTH);
            return new String(plainText, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            throw new EncryptionException("Problems during decrypting data", ex);
        }
    }

    public void cleanUp() {
        hmacSha256.remove();
    }

    private Cipher initCipher(int encryptMode, String secretKey, byte[] cipherMessageWithIV) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        Key key = generateKeyFromString(secretKey);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding", PROVIDER);
        AlgorithmParameterSpec gcmIv = new GCMParameterSpec(128, cipherMessageWithIV, 0, GCM_IV_LENGTH);
        cipher.init(encryptMode, key, gcmIv);
        return cipher;
    }

    private static Key generateKeyFromString(final String secKey) {
        return new SecretKeySpec(secKey.getBytes(), ENCRYPTION_ALGORITHM);
    }

    private String generateSign(long date, M3Credentials credentials, String userIdentifier) {
        String accessKey = credentials.getAccessKey();
        String secretKey = credentials.getSecretKey();

        byte[] bytes = StandardCharsets.UTF_8.encode(String.format("%s%s", secretKey, date)).array();
        final SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, SIGN_ALGORITHM);

        try {
            hmacSha256.get().init(secretKeySpec);
        } catch (InvalidKeyException e) {
            throw new M3SdkException("Failed to init signer");
        }
        byte[] message = hmacSha256.get().doFinal(String.format("M3-POST:%s:%s:%s", accessKey, date, userIdentifier).getBytes());
        return generateHash(message);
    }

    private String generateHash(byte[] message) {
        StringBuilder builder = new StringBuilder();
        for (final byte element : message) {
            builder.append(Integer.toString((element & 0xff) + 0x100, 16));
        }
        return builder.toString();
    }

    private Mac initMacInstance() {
        try {
            return Mac.getInstance(SIGN_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new M3SdkException("Can not create client due to signature creation error");
        }
    }

}

