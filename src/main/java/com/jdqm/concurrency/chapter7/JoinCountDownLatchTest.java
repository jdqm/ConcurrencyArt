package com.jdqm.concurrency.chapter7;

/**
 * Created by Jdqm on 2021/3/5
 */
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws Exception{
        Thread parser1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parser1 finished");
            }
        });

        Thread parser2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parser2 finished");
            }
        });

        parser1.start();
        parser2.start();
        parser1.join();
        parser2.join();
        System.out.println("all parser finished");
    }
}
