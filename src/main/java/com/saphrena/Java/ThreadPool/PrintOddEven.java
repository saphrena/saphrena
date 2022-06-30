package com.saphrena.Java.ThreadPool;

/**
 * @author saphrena
 * @description Java两个线程交替打印奇偶数
 * 1.仅通过synchronized关键字实现交替打印奇偶数
 * 两个线程竞争同一个对象锁，每次打印一个数字后释放锁，然后另一个线程拿到锁打印下一个数字。
 * @create 2022/6/30 030 20:54
 */


public class PrintOddEven {

    private static int count;
    private static final Object object = new Object();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (object) {
                        if ((count % 2) == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }

            }
        }, "偶数线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (object) {
                        if ((count % 2) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }

            }
        }, "奇数线程").start();
    }

}