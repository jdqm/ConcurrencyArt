package com.jdqm.concurrency.chapter7;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Jdqm on 2021/3/5
 */
public class CountDownLatchTest {
    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws Exception{
        Thread parser1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parser1 finished");
                countDownLatch.countDown();
            }
        });

        Thread parser2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parser2 finished");
                countDownLatch.countDown();
            }
        });

        parser1.start();
        parser2.start();
        countDownLatch.await();
        System.out.println("all parser finished");
    }
}
