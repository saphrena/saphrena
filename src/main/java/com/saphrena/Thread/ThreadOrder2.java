package com.saphrena.Thread;

/**
 * @author 热河
 * @created 2022/4/28 13:02
 * @project saphrena
 * @Description 在主线程中通过join()方法指定顺序,子线程指的是发生在Thread内部的代码，主线程指的是发生在main函数中的代码
 * 在main函数中通过join()方法让主线程阻塞等待以达到指定顺序执行的目的。
 */
public class ThreadOrder2 {
    public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("打开冰箱！");
//            }
//        });
        Thread thread1 = new Thread(() -> System.out.println("打开冰箱！"));

        Thread thread2 = new Thread(() -> System.out.println("拿出一片瓶牛奶！"));

        Thread thread3 = new Thread(() -> System.out.println("关上冰箱！"));

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
    }
}
