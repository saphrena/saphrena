package com.saphrena.LeetCode;


/**
 * @author 热河
 * @created 2022/5/22 20:00
 * @project saphrena
 * @Description
 */
public class ResolveJieCheng {
    public static long jieCheng(int N){
        long ans = 0;
        long cur = 1;
        for (int i = 1; i <= N; i++) {
            cur = cur * i;
            ans += cur;
        }
        return ans;
    }


    public static void main(String[] args) {
        int N = 10;
        System.out.println(jieCheng(N));
    }
}
