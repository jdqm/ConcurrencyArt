package com.jdqm.concurrency.chapter6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by Jdqm on 2021/3/5
 */
public class AtomicReferenceFieldUpdaterTest {
    static AtomicReferenceFieldUpdater<AtomicReferenceTest.User, String> updater
            = AtomicReferenceFieldUpdater.newUpdater(AtomicReferenceTest.User.class, String.class, "name");

    public static void main(String[] args) {
        AtomicReferenceTest.User user = new AtomicReferenceTest.User("Jdqm", 20);
        updater.compareAndSet(user, "Jdqm", "updater");
        System.out.println(updater.get(user));
    }
}
