package com.saphrena.Sort;

import java.util.Arrays;

/**
 * @author 热河
 * @created 2022/5/27 10:32
 * @project saphrena
 * @Description
 */
public class SheelSort {
    public static void sort(int []arr) {
        //增量在刚开始的时候为数组长度的一半，以后每次减半，直到增量大于0不成立
        for(int d = (int)(arr.length/2); d > 0; d = (int)(d/2)) {
            //首先从每组的第二个数开始，第一次循环是第一组第二个数与第一个数比较，第二次循环是第二组第二个数与第二组第一个数比较
            //进行d次循环后，如果后面还有数
            //第d次循环是第一组第3个数与前面已从小到大排好序的序列比较，第d+1次循环是第二组与第3个数与前面已排好序的序列比较,
            //差不多就是对每组分别进行插入排序
            for(int i = d;i<arr.length;i++) {
                int tempIndex = i;
                while(tempIndex - d >=0 && arr[tempIndex] < arr[tempIndex-d]) {
                    int temp = arr[tempIndex];
                    arr[tempIndex] = arr[tempIndex-d];
                    arr[tempIndex-d] = temp;
                    tempIndex = tempIndex-d;
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

