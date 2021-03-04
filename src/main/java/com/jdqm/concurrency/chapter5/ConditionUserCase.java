package com.jdqm.concurrency.chapter5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Jdqm on 2021/3/3
 */
public class ConditionUserCase {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void conditionWait() throws InterruptedException {
        System.out.println("conditionWait");
        lock.lock();
        try {
            condition.await();
            System.out.println("condition.await");
        } finally {
            lock.unlock();
        }
    }


    public static void conditionSignal() throws InterruptedException {
        System.out.println("conditionSignal");
        lock.lock();
        try {
            condition.signal();
            System.out.println("condition.signal");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    conditionWait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    conditionSignal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
