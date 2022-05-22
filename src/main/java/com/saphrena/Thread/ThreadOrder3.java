package com.saphrena.Thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author 热河
 * @created 2022/4/28 13:10
 * @project saphrena
 * @Description 通过倒数计时器CountDownLatch实现，只要检测到计数器为0当前线程就可以往下执行而不用管相应的thread是否执行完毕。
 */
public class ThreadOrder3 {
    private static CountDownLatch countDownLatch1 = new CountDownLatch(1);

    private static CountDownLatch countDownLatch2 = new CountDownLatch(1);

    public static void main(String[] args) {
        final Thread thread1 = new Thread(() -> {
            System.out.println("打开冰箱！");
            countDownLatch1.countDown();
        });

        final Thread thread2 = new Thread(() -> {
            try {
                countDownLatch1.await();
                System.out.println("拿出一瓶牛奶！");
                countDownLatch2.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        final Thread thread3 = new Thread(() -> {
            try {
                countDownLatch2.await();
                System.out.println("关上冰箱！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //下面三行代码顺序可随意调整，程序运行结果不受影响
        thread3.start();
        thread1.start();
        thread2.start();
    }

}
