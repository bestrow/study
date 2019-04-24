package com.bestrow.ch1.safeend;

public class HasInterruptedException {

    private static class UseThread extends Thread {

        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(threadName + " interrupt flag is " + isInterrupted());
                    interrupt();
                    e.printStackTrace();
                }
                System.out.println(threadName);
            }
            System.out.println(threadName + " interrupt flag is " + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new UseThread("HasInterruptedEx");
        endThread.start();
        Thread.sleep(500);
        endThread.interrupt();
    }
}
