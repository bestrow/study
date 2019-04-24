package com.bestrow.ch1.syn;

import com.bestrow.ch1.tools.SleepTools;

public class SynClzAndInst {

    // 使用类锁的线程
    private static class SynClass extends Thread {
        @Override
        public void run() {
            System.out.println("TestClass is running");
            synClass();
        }
    }

    // 使用对象锁的线程
    private static class InstanceSyn implements Runnable {
        private SynClzAndInst synClzAndInst;

        public InstanceSyn(SynClzAndInst synClzAndInst) {
            this.synClzAndInst = synClzAndInst;
        }

        @Override
        public void run() {
            System.out.println("TestInstance is running..." + synClzAndInst);
            synClzAndInst.instance();
        }
    }

    // 锁对象
    private synchronized void instance() {
        SleepTools.second(3);
        System.out.println("synInstance is going..." + this.toString());
        SleepTools.second(3);
        System.out.println("synInstance is ended " + this.toString());
    }

    // 锁对象
    private synchronized void instance2() {
        SleepTools.second(3);
        System.out.println("synIntance2 is going..." + this.toString());
        SleepTools.second(3);
        System.out.println("synIntance2 is ended " + this.toString());
    }

    // 类锁 实际是锁类的class对象
    private static synchronized void synClass() {
        SleepTools.second(1);
        System.out.println("synClass going...");
        SleepTools.second(1);
        System.out.println("synClass end");
    }

    public static void main(String[] args) {
        SynClzAndInst synClzAndInst = new SynClzAndInst();
        Thread t1 = new Thread(new InstanceSyn(synClzAndInst));

        SynClzAndInst synClzAndInst2 = new SynClzAndInst();
        Thread t2 = new Thread(new InstanceSyn(synClzAndInst2));

        t1.start();
        t2.start();
    }
}
