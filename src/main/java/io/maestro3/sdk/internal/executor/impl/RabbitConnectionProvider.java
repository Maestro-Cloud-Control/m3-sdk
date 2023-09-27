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

package io.maestro3.sdk.internal.executor.impl;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ShutdownNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RabbitConnectionProvider {

    private static final Logger LOG = LoggerFactory.getLogger(RabbitConnectionProvider.class);

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final ConnectionFactory connectionFactory;
    private Connection connection;
    private Channel writeChannel;
    private Channel readChannel;

    public RabbitConnectionProvider(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public boolean init() throws IOException, TimeoutException {
        return init(false);
    }

    public boolean init(boolean full) throws IOException, TimeoutException {
        lock.writeLock().lock();
        try {
            if (full || connection == null || !connection.isOpen()) {
                LOG.info("Full initialization of M3 sdk client");
                fullInit();
                return true;
            }

            if (writeChannel == null || !writeChannel.isOpen()) {
                LOG.info("Write channel created");
                writeChannel = connection.createChannel();
            }

            boolean readChannelUpdated = false;
            if (readChannel == null || !readChannel.isOpen()) {
                LOG.info("Read channel created");
                readChannel = connection.createChannel();
                readChannelUpdated = true;
            }
            return readChannelUpdated;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Channel getReadChannel() {
        lock.readLock().lock();
        try {
            return writeChannel;
        } finally {
            lock.readLock().unlock();
        }
    }

    public Channel getWriteChannel() {
        lock.readLock().lock();
        try {
            return writeChannel;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void closeAll() {
        close(writeChannel);
        close(readChannel);
        close(connection);
    }

    private void fullInit() throws IOException, TimeoutException {
        closeAll();
        connection = connectionFactory.newConnection();
        writeChannel = connection.createChannel();
        readChannel = connection.createChannel();
    }

    private <T extends ShutdownNotifier & AutoCloseable> void close(T resource) {
        if (resource == null || !resource.isOpen()) {
            return;
        }

        try {
            resource.close();
        } catch (Exception ex) {
            LOG.error("Failed to close resources to M3 rabbit", ex);
        }
    }
}
