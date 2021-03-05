package com.jdqm.concurrency.chapter6;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Jdqm on 2021/3/5
 */
public class AtomicIntegerTest {
    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }
}
