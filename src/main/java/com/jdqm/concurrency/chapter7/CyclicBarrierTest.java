package com.jdqm.concurrency.chapter7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Jdqm on 2021/3/5
 */
public class CyclicBarrierTest {
    //由于小于3个线程，所有无法突破屏障，两个线程都在屏障处等待
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();

        cyclicBarrier.await();
        System.out.println(2);
    }
}
