package com.saphrena.Java;

/**
 * @author saphrena
 * @description 功能描述
 * @create 2022/5/26 026 22:21
 */


public class DeadLock {
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }

    public static class Thread1 implements Runnable{
        @Override
        public void run() {
            synchronized (obj1){
                System.out.println("Thread1拿到了obj1的锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2){
                    System.out.println("Thread1拿到了obj2的锁");
                }
            }
        }
    }

    public static class Thread2 implements Runnable{
        @Override
        public void run() {
            synchronized (obj2) {
                System.out.println("Thread2拿到了obj2的锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println("Thread2拿到了obj1的锁");
                }
            }
        }
    }
}