package com.jdqm.concurrency.chapter7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Jdqm on 2021/3/5
 */
public class CyclicBarrierTest3 {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
//                    e.printStackTrace();
                }
            }
        });

        thread.start();
        thread.interrupt();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
//            e.printStackTrace();
        }
        System.out.println(cyclicBarrier.isBroken());
    }
}
