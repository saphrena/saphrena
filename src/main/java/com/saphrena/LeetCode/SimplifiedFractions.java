package com.saphrena.LeetCode;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * @author saphrena
 * @description 最简分数
 * @create 2022/7/14 014 23:55
 *
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于
 * n 的 最简 分数 。分数可以以 任意 顺序返回
 *
 * 最大公约数gcd
 * 满足分母小于等于 n 的最简分数，最简分数意味着分子和分母的最大公约数为 1，即gcd=1。
 * 因此两层for，暴力枚举分子和分母，判断分子和分母的最大公约数是否为 1。
 * 若分子和分母的最大公约数为 11，则说明是最简分数。
 * 若分子和分母的最大公约数不为 11，则说明不是最简分数。
 *
 */


public class SimplifiedFractions {

    static int gcd(int a, int b) { // 欧几里得算法(辗转相除法)
        return b == 0 ? a : gcd(b, a % b);
    }
    public static List<String> resolve(int n) {
        List<String> res = Lists.newArrayList();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) res.add(i + "/" + j);
            }
        }
        return res;
    }



    public static void main(String[] args) {
        final List<String> res = resolve(4);
        System.out.println(res);
    }


}