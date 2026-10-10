package com.atguigu.gulimall.search.thread;

import java.util.concurrent.*;

public class TreadTest {
//    public static void main (String[] args) {
//        System.out.println("main...start...");
//    }

    public static void main(String[] args) {
        System.out.println("main...start...");
//        1.继承Thread
//        Thread01 thread01 = new Thread01();
//        thread01.start();
//        2.实现Runnable
//        new Thread(new Runnable01()).start();
//        3.实现Callable + FutureTask
//        FutureTask<Integer> task = new FutureTask<>(new Callable01());
//        new Thread(task).start();
//        4.线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 200, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100000), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        executor.execute(new Runnable01());

        System.out.println("main...end...");
    }
    public static class Thread01 extends Thread {
        @Override
        public void run() {
            System.out.println("当前线程" + Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("运行结果" + i);
        }
    }
    public static class Runnable01 implements Runnable {
        @Override
        public void run() {
            System.out.println("当前线程" + Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("运行结果" + i);
        }
    }
    public static class Callable01 implements Callable<Integer> {
        @Override
        public Integer call() {
            System.out.println("当前线程" + Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("运行结果" + i);
            return i;
        }
    }
}
