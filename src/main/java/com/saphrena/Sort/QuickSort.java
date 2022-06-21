package com.saphrena.Sort;

import java.util.Arrays;

/**
 * @author 热河
 * @created 2022/5/27 16:22
 * @project saphrena
 * @Description
 */
public class QuickSort {
    public static int[] resolve(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i<j) {
            while ((i<j)&&(arr[j]>pivot)) {
                j--;
            }
            while ((i<j)&&(arr[i]<pivot)) {
                i++;
            }
            if ((arr[i]==arr[j])&&(i<j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i-1>start) arr=resolve(arr,start,i-1);
        if (j+1<end) arr=resolve(arr,j+1,end);
        return (arr);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2};
        int[] result = resolve(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(result));
    }
}
