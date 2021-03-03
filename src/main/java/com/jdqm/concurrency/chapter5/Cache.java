package com.jdqm.concurrency.chapter5;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Jdqm on 2021/3/2
 */
public class Cache {
    static Map<String, Object> map = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock rl = rwl.readLock();
    static Lock wl = rwl.writeLock();

    public static final Object get(String key) {
        rl.lock();
        try {
            return map.get(key);
        } finally {
            rl.unlock();
        }
    }

    public static final void put(String key, Object value) {
        wl.lock();
        try {
            map.put(key, value);
        } finally {
            wl.unlock();
        }
    }

    public static final void clear() {
        wl.lock();
        try {
            map.clear();
        } finally {
            rl.unlock();
        }
    }
}
