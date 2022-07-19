package com.saphrena.LeetCode.arrays.array;

import java.util.Arrays;


/**
 * @author saphrena
 * @description 整数数组两两之差绝对值最小的值
 * @create 2022/7/19 019 23:41
 */


public class MinSub {
    public static int resolve(int[] array){
        Arrays.sort(array);
        int minSub = Integer.MAX_VALUE;
        for(int i = 0;i < array.length - 1;i ++){
            int tmp = Math.abs(array[i + 1] - array[i]);
            minSub = Math.min(tmp, minSub);
        }
        return minSub;
    }

    public static void main(String[] args) {
        int[] array = {1,3,7};
        final int res = resolve(array);
        System.out.println(res);
    }
}