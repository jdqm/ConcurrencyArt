package com.jdqm.concurrency.chapter6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by Jdqm on 2021/3/5
 */
public class AtomicIntegerFieldUpdaterTest {
    static AtomicIntegerFieldUpdater<AtomicReferenceTest.User> ai
            = AtomicIntegerFieldUpdater.newUpdater(AtomicReferenceTest.User.class, "old");

    public static void main(String[] args) {
        AtomicReferenceTest.User user = new AtomicReferenceTest.User("Jdqm", 19);
        ai.getAndIncrement(user);
        System.out.println(ai.get(user));
    }
}
