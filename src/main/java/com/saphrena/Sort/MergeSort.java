package com.saphrena.Sort;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author saphrena
 * @description 归并排序
 * @create 2022/6/20 020 20:57
 */

@Slf4j
public class MergeSort {
    public static void Sort(int[] arr, int[] temp, int start, int end){

        // >>运算符是按位右移运算符,一般来说-i << k等效于i*(2^k)，而i >> k等效于i/(2^k)
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        Sort(arr, temp, start1, end1);
        Sort(arr, temp, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            temp[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            temp[k++] = arr[start1++];
        while (start2 <= end2)
            temp[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = temp[k];
    }


    public static void main(String[] args) {
         int[] arr= {7,23,45,65,23,8,34};
         int len = arr.length;
         int[] temp = new int[len];
         log.info(Arrays.toString(arr));
         Sort(arr,temp,0,len-1);
         log.info(Arrays.toString(arr));


    }
}