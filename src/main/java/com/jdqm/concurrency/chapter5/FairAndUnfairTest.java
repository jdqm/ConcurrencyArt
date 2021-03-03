package com.jdqm.concurrency.chapter5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Jdqm on 2021/3/2
 */
public class FairAndUnfairTest {
    private static ReentrantLock2 fairLock = new ReentrantLock2(true);
    private static ReentrantLock2 unFairLock = new ReentrantLock2(false);

    public static void main(String[] args) {
//        testLock(fairLock);
        testLock(unFairLock);
    }

    public static void testLock(ReentrantLock2 lock) {
        for (int i = 0; i < 5; i++) {
            Job job = new Job(lock);
            job.start();
        }
    }

    private static class Job extends Thread {
        private ReentrantLock2 lock;

        public Job(ReentrantLock2 lock) {
            this.lock = lock;
        }
        @Override
        public void run() {
            lock.lock();
            System.out.print("Lock by " + getId());
            System.out.println(", Waiting by " + lock.getQueuedThreads() );
            lock.unlock();

            lock.lock();
            System.out.print("Lock by " + getId());
            System.out.println(", Waiting by " + lock.getQueuedThreads());
            lock.unlock();
        }
    }


    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}
