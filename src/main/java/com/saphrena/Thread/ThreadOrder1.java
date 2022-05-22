package com.saphrena.Thread;



/**
 * @author 数据组-热河
 * @created 2022/4/22 17:03
 * @project leetcode
 * @Description 在子线程中通过join()方法指定顺序,通过join()方法使当前线程“阻塞”，等待指定线程执行完毕后继续执行。
 */


public class ThreadOrder1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println("打开冰箱"));

        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
                // 让主线程等待自子线程执行结束之后再去运行主线程
                // 谁调用join方法，谁就强占cpu资源，直至执行结束
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("拿出一瓶牛奶");
        });

        Thread thread3 = new Thread(() -> {
            try {
                thread2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("关上冰箱！");
        });

        thread3.start();
        thread1.start();
        thread2.start();

    }
}

