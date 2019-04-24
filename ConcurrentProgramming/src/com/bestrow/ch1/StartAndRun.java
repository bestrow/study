package com.bestrow.ch1;

import com.bestrow.ch1.tools.SleepTools;

import java.util.concurrent.TimeUnit;

public class StartAndRun {

    public static class ThreadRun extends Thread {
        @Override
        public void run() {
            int i = 90;
            while (i > 0) {
                SleepTools.ms(1000);
                System.out.println("I am " + Thread.currentThread().getName() + " and now the i=" + i--);
            }
        }
    }

    public static void main(String[] args) {
        ThreadRun beCalled = new ThreadRun();
        beCalled.setName("beCalled");
        beCalled.run(); // 普通方法
        beCalled.start(); // 当成线程
    }
}
