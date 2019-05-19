package com.bestrow.ch2.tools;

import com.bestrow.ch1.tools.SleepTools;

import java.util.concurrent.CountDownLatch;

/**
 * 演示CountDownLatch,有5个初始化的线程，6个扣除点
 */

public class UseCountDownLatch {

    static CountDownLatch latch = new CountDownLatch(6);

    private static class InitThread implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread_"+Thread.currentThread().getId()+"ready init work......");

            latch.countDown(); // 初始化线程完成工作了
            for (int i = 0; i < 2; i++) {
                System.out.println("Thread_"+Thread.currentThread().getId()+"......continue do its work");
            }
        }
    }

    // 业务线程
    private static class BusiThread implements Runnable{
        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println("BusiThread_"+Thread.currentThread().getId()+" do business----");
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SleepTools.ms(1);
                System.out.println("Thread_"+Thread.currentThread().getId()+" ready init work step 1st.......");
                latch.countDown();
                System.out.println("begin step 2nd");
                SleepTools.ms(1);
                System.out.println("Thread_"+Thread.currentThread().getId()+" ready init work step 2nd.......");
                latch.countDown();
            }
        }).start();
        new Thread(new BusiThread()).start();
        for (int i = 0; i <=3; i++) {
            Thread thread = new Thread(new InitThread());
            thread.start();
        }
        latch.await();
        System.out.println("Main do its work......");
    }

}
