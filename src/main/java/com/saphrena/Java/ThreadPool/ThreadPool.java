package com.saphrena.Java.ThreadPool;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/**
 * @author saphrena
 * @description 线程池
 * @create 2022/5/30 030 23:31
 * 实现线程池需要一个阻塞队列+存放线程的容器
 */
@Getter
@Setter
public class ThreadPool {

    /** 默认线程池中的线程的数量 */
    private static final int WORK_NUM = 5;

    /** 默认处理任务的数量 */
    private static final int TASK_NUM = 100;

    /** 存放任务 */
    private final BlockingQueue<Runnable> taskQueue;

    private final Set<WorkThread> workThreads;//保存工作线程的集合

    private int workNumber;//线程数量

    private int taskNumber;//任务数量

    public ThreadPool(int workNumber , int taskNumber) {
        if (taskNumber<=0){
            taskNumber = TASK_NUM;
        }
        if (workNumber<=0){
            workNumber = WORK_NUM;
        }
        this.taskQueue = new ArrayBlockingQueue<>(taskNumber);
        this.workNumber = workNumber;
        this.taskNumber = taskNumber;

        workThreads = new HashSet<>();

        //工作线程准备好了
        //启动一定数量的线程数，从队列中获取任务处理
        for (int i=0;i<workNumber;i++) {
            WorkThread workThread = new WorkThread("thead_"+i);
            workThread.start();
            workThreads.add(workThread);
        }
    }

    /**
     * 线程池执行任务的方法，其实就是往BlockingQueue中添加元素
     */
    public void execute(Runnable task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 销毁线程池
     */
    public void destroy(){
        System.out.println("ready close pool...");
        for (WorkThread workThread : workThreads) {
            workThread.stopWorker();
            workThread = null;//help gc
        }
        workThreads.clear();
    }

    /** 内部类，工作线程的实现
     * WorkThread实现Thread，run方法实现也很简单，因为有一个stop方法，
     * 所以这里需要while判断，之后从taskQueue队列中，获取任务。
     * 如果获取不到就阻塞，获取到的话runnable.run();就执行任务，之后把任务变成null
     * 销毁线程只需要遍历set，把每个线程停止，并且变为null就行了
     * 执行线程任务execute，只需要从往阻塞队列中添加任务就行了
     * */
    private class WorkThread extends Thread{
        public WorkThread(String name){
            super();
            setName(name);
        }
        @Override
        public void run() {
            while (!interrupted()) {
                try {
                    Runnable runnable = taskQueue.take();//获取任务
                    if (runnable !=null) {
                        System.out.println(getName()+" ready execute:"+runnable.toString());
                        runnable.run();//执行任务
                    }
                    runnable = null;//help gc
                } catch (Exception e) {
                    interrupt();
                    e.printStackTrace();
                }
            }
        }

        public void stopWorker(){
            interrupt();
        }
    }
}

