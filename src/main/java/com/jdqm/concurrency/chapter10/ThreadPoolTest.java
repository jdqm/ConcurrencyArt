package com.jdqm.concurrency.chapter10;

import java.util.concurrent.*;

/**
 * Created by Jdqm on 2021/3/6
 */
public class ThreadPoolTest {
    static ExecutorService executorService = Executors.newSingleThreadExecutor();
    public static void main(String[] args) {

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("call");
                Thread.currentThread().sleep(3000);
                return "Future";
            }
        };
        Future<String> future = executorService.submit(callable);
        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
