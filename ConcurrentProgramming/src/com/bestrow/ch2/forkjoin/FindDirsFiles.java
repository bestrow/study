package com.bestrow.ch2.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class FindDirsFiles extends RecursiveAction {

    private File path; // 当前任务需要搜寻的目录

    public FindDirsFiles(File path) {
        this.path = path;
    }

    @Override
    protected void compute() {

        List<FindDirsFiles> subTasks = new ArrayList<>();

        File[] files = path.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    subTasks.add(new FindDirsFiles(file));
                } else {
                    // 遇到文件，检查
                    if (file.getAbsolutePath().endsWith("txt")) {
                        System.out.println("文件: " + file.getAbsolutePath());
                    }
                }
            }
            if (!subTasks.isEmpty()) {
                for (FindDirsFiles subTask : invokeAll(subTasks)) {
                    subTask.join(); // 等待子任务执行
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            ForkJoinPool pool = new ForkJoinPool();
            FindDirsFiles task = new FindDirsFiles(new File("E:/"));
            pool.execute(task); // 异步调用
            System.out.println("Task is Running.....");

            Thread.sleep(1);
            int otherWork = 0;
            for (int i = 0; i < 100; i++) {
                otherWork = otherWork + i;
            }
            System.out.println("Main Thread done sth.....,otherWork=" + otherWork);
            task.join(); // 阻塞的方法
            System.out.println("Task end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
