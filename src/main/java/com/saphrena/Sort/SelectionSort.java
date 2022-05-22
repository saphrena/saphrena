package com.saphrena.Sort;

import java.util.Arrays;

/**
 * @author 热河
 * @created 2022/5/22 20:20
 * @project saphrena
 * @Description
 */


// 0～n-1位置选个数放到0位置
// 1～n-1位置选个数放到1位置
// ......

public class SelectionSort {
    public static void sort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            int minIndex = i;
            //j=i;意味着i之前的数都是有序的
            for (int j = i; j < num.length; j++) {
                minIndex = num[j]<num[minIndex]? j : minIndex;
            }
            int temp = num[i];
            num[i] = num[minIndex];
            num[minIndex] = temp;
        }
        System.out.println(Arrays.toString(num));
    }

    public static void main(String[] args) {
        int[] num ={29,10,14,37,14,2,8,1,7,6,5};
        sort(num);
    }
}

