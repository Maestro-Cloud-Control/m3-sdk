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

package io.maestro3.sdk.internal.signer;

import io.maestro3.sdk.internal.provider.IM3CredentialsProvider;
import io.maestro3.sdk.internal.provider.impl.M3StaticCredentialsProvider;
import io.maestro3.sdk.internal.signer.impl.M3Signer;
import io.maestro3.sdk.v3.core.M3ApiRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class M3SignerTest {

    private IM3Signer signer;
    private IM3CredentialsProvider credentialsProvider;
    private M3ApiRequest request;
    private String accessKey;
    private String secretKey;
    private String dataToEncrypt;

    @Before
    public void setUp() {
        accessKey = UUID.randomUUID().toString();
        secretKey = UUID.randomUUID().toString().substring(0, 16);
        request = new M3ApiRequest();
        request.setTimestamp(System.currentTimeMillis());
        request.setUserIdentifier("test");
        request.setRequestBody("{}");

        credentialsProvider = new M3StaticCredentialsProvider(accessKey, secretKey);
        signer = new M3Signer(credentialsProvider);
        dataToEncrypt = UUID.randomUUID().toString();
    }

    @Test
    public void testSign() {
        request = signer.sign(request, accessKey);

        Assert.assertEquals("test", request.getUserIdentifier());
        Assert.assertNotNull(request.getSignature());
        assertNotNull(request.getAccessKey());
    }

    @Test
    public void testIsSignValidWhenAccessKeyIsTheSame() {
        request = signer.sign(request, accessKey);

        boolean result = signer.isSignValid(request.getSignature(), request.getTimestamp(), request.getAccessKey());

        assertTrue(result);
    }

    @Test
    public void testIsSignNotValidWhenCredentialsAreDifferent() {
        request = signer.sign(request, accessKey);

        String accessKey = UUID.randomUUID().toString();
        signer = new M3Signer(new M3StaticCredentialsProvider(accessKey, UUID.randomUUID().toString().substring(0, 15)));
        boolean result = signer.isSignValid(request.getSignature(), request.getTimestamp(), accessKey);
        assertFalse(result);
    }


    @Test
    public void testEncryptDecrypt() {
        String encryptedData = signer.encrypt(dataToEncrypt, accessKey);
        String decryptedData = signer.decrypt(encryptedData, accessKey);
        assertNotEquals(dataToEncrypt, encryptedData);
        assertEquals(dataToEncrypt, decryptedData);
    }
}