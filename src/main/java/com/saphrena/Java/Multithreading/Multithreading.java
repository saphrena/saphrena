package com.saphrena.Java.Multithreading;

/**
 * @author saphrena
 * @description 多线程 && 站台售票
 * @create 2022/7/7 007 22:16
 *
 * 程序分析：
 * 1.票数要使用同一个静态值
 * 2.为保证不会出现卖出同一个票数，要java多线程同步锁。
 *
 * 设计思路：
 * 1.创建一个站台类Station，继承Thread，重写run方法，在run方法里面执行售票操作！售票要使用同步锁：即有一个站台卖这张票时，其他站台要等这张票卖完！
 * 2.创建主方法调用类
 */


public class Multithreading extends Thread{

    // 类名相当与车站
    // 通过构造方法给线程名字赋值
    public Multithreading(String name) {
        super(name);
    }

    // 为了保持票数的一致，票数要静态
    static int tick = 20;
    // 创建一个静态钥匙
    static Object object = "object";

    @Override
    public void run() {
        while(tick>0){
            // 这个很重要，必须使用一个锁，
            // 进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来
            synchronized (object){
                if(tick>0){
                    System.out.println(getName()+"卖出了第"+tick+"张票");
                    tick--;
                } else {
                    System.out.println("票卖完了");
                }
            }

            try {
                sleep(10000); //休息一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        //实例化站台对象，并为每一个站台取名字
        final Multithreading 窗口1 = new Multithreading("窗口1");
        final Multithreading 窗口2 = new Multithreading("窗口2");
        final Multithreading 窗口3 = new Multithreading("窗口3");

        窗口1.start();
        窗口2.start();
        窗口3.start();
    }
}