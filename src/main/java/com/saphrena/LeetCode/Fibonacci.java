package com.saphrena.LeetCode;

/**
 * @author saphrena
 * @description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 斐波纳契数列：f(x)=f(x−1)+f(x−2)
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 滚动数组
 * @create 2022/6/16 016 1:12
 */


public class Fibonacci {
    public int climbStairs(int n ) {
        int p = 0, q = 0, res = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = res;
            res = p + q;
        }
        return res;
    }

    public int climbStairs1(int n){  //递归
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairs1(n-1) + climbStairs(n-2);
    }

    public int climbStairs2(int n){
        if(n <= 2){
            return  n;
        }
         int[] f = new int[n];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < n; i++) {
            f[i] = f[i -1] + f[i -2];
        }
        return f[n - 1];
    }


    public static void main(String[] args) {
        int n = 3;
        final int climbStairs  = new Fibonacci().climbStairs(n);
        final int climbStairs1 = new Fibonacci().climbStairs1(n);
        final int climbStairs2 = new Fibonacci().climbStairs2(n);
        System.out.println(climbStairs);
        System.out.println(climbStairs1);
        System.out.println(climbStairs2);
    }
}