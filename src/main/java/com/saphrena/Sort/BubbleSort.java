package com.saphrena.Sort;

import java.util.Arrays;

/**
 * @author 热河
 * @created 2022/5/27 11:28
 * @project saphrena
 * @Description
 */
public class BubbleSort {
    public static void sort(int[] arr){
        int len = arr.length;
        int tmp;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len-i-1; j++) {
                if(arr[j] > arr[j + 1]){
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {29,10,14,37,14,2,8,1,7,6,5};
        sort(arr);

    }
}
