package com.jdqm.concurrency.chapter6;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by Jdqm on 2021/3/5
 */
public class AtomicIntegerArrayTest {
    static int[] value = new int[]{1, 2, 3};
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}
