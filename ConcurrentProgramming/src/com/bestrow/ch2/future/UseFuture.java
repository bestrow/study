package com.bestrow.ch2.future;

import com.bestrow.ch1.tools.SleepTools;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class UseFuture {

    /*实现Callable接口，允许有返回值*/
    private static class UseCallable implements Callable<Integer> {

        private int sum;

        @Override
        public Integer call() throws Exception {
            System.out.println("Callable子线程开始计算");
            Thread.sleep(2000);
            for (int i = 0; i < 5000; i++) {
                sum = sum + i;
            }
            System.out.println("Callable子线程计算完成，结果=" + sum);
            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UseCallable useCallable = new UseCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(useCallable);
        new Thread(futureTask).start();
        Random r = new Random();
        SleepTools.second(1);
        if (r.nextBoolean()) { // 随机决定是获得结果还是终止任务
            System.out.println("Get UseCallable result = " + futureTask.get());
        } else {
            System.out.println("中断计算");
            futureTask.cancel(true);
        }
    }
}
