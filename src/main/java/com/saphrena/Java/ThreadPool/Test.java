package com.saphrena.Java.ThreadPool;

import lombok.Data;

/**
 * @author saphrena
 * @description 线程池测试
 * @create 2022/5/30  23:43
 */


public class Test {
    private static final int TASK_NUM = 50;//任务的个数

    public static void main(String[] args) {
        ThreadPool myPool = new ThreadPool(3,50);
        for (int i = 0; i < TASK_NUM; i++) {
            myPool.execute(new MyTask("task_"+i));
        }
    }
     @Data
    static class MyTask implements Runnable{

        private String name;
        public MyTask(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("task :"+name+" end...");
        }

        @Override
        public String toString() {

            // TODO Auto-generated method stub
            return "name = "+name;
        }
    }
}