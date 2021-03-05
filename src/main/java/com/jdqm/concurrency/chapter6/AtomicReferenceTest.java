package com.jdqm.concurrency.chapter6;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Jdqm on 2021/3/5
 */
public class AtomicReferenceTest {
    private static AtomicReference<User> ai = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("Jdqm", 19);
        ai.set(user);
        User updateUser = new User("updater", 20);
        ai.compareAndSet(user, updateUser);
        System.out.println(ai.get().getName());
        System.out.println(ai.get().getOld());
    }
    public static class User {
        public volatile String name;
        public volatile int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOld() {
            return old;
        }

        public void setOld(int old) {
            this.old = old;
        }
    }
}
