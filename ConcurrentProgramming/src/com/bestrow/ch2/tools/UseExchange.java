package com.bestrow.ch2.tools;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Exchanger;

public class UseExchange {

    private static final Exchanger<Set<String>> exchange = new Exchanger<>();

    public static void main(String[] args) {

        // 第一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                Set<String> setA = new HashSet<>(); // 存放数据的容器
                try {
                    // 添加数据
                    setA = exchange.exchange(setA);
                } catch (InterruptedException e) {

                }

            }
        }).start();

        // 第二个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                Set<String> setB = new HashSet<>(); // 存放数据的容器
                try {
                    // 添加数据
                    setB = exchange.exchange(setB);
                } catch (InterruptedException e) {

                }
            }
        }).start();

    }
}
