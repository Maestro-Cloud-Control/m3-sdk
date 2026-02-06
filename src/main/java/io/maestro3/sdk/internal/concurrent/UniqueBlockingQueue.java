package io.maestro3.sdk.internal.concurrent;

import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class UniqueBlockingQueue<E> {
    private final BlockingQueue<E> queue = new LinkedBlockingQueue<>();
    private final Set<E> unique = ConcurrentHashMap.newKeySet();

    public boolean add(E element) {
        if (unique.add(element)) {
            boolean added = false;
            try {
                added = queue.offer(element);
                return added;
            } finally {
                if (!added) {
                    unique.remove(element);
                }
            }
        }
        return false;
    }

    public E take() throws InterruptedException {
        E element = queue.take();
        unique.remove(element);
        return element;
    }
}
