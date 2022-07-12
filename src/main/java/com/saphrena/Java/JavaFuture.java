package com.saphrena.Java;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author saphrena
 * @description Java  Future  用法
 * @create 2022/7/12 012 22:49
 */


public class JavaFuture {
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();


    public static void main(String[]args){
        System.out.println("hello world");

        Future<Integer> future = calcute(9);
        while (!future.isDone()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("正在执行");
            }
        }
        try {
            int result = future.get();
            System.out.println("result = " + result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Future<Integer>calcute(Integer i) {
        return executorService.submit(() -> {
            Thread.sleep(1000);
            System.out.println("return future for " + i);
            return i *i;
        });
    }
}