package com.saphrena.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 热河
 * @created 2022/4/28 13:14
 * @project saphrena
 * @Description 通过创建单一化线程池newSingleThreadExecutor()实现，串行执行所有任务。
 */
public class ThreadOrder4 {

        static ExecutorService executorService = Executors.newSingleThreadExecutor();

        public static void main(String[] args) {
            final Thread thread1 = new Thread(() -> System.out.println("打开冰箱！"));

            final Thread thread2 =new Thread(() -> System.out.println("拿出一瓶牛奶！"));

            final Thread thread3 = new Thread(() -> System.out.println("关上冰箱！"));
            final Thread thread4 = new Thread(() -> System.out.println("关好了吗？"));
            executorService.submit(thread1);
            executorService.submit(thread2);
            executorService.submit(thread3);
            executorService.submit(thread4);
            executorService.shutdown();        //使用完毕记得关闭线程池
        }
    }

