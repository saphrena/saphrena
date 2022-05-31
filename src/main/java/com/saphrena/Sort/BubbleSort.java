package com.saphrena.Sort;

import java.util.Arrays;

/**
 * @author 热河
 * @created 2022/5/27 11:28
 * @project saphrena
 * @Description
 */
public class BubbleSort {
    public static void sortDoubleFor(int[] arr){
        int len = arr.length;
        if(len == 0){return;}
        for (int i = 0; i < len; i++) {   // 控制比较的轮数
            for (int j = 0; j < len - i - 1; j++) {  // 控制每轮比较的次数
                if(arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static  void sortOnlyOneFor(int[] arr){
        int len  = arr.length - 1;
        for (int i = 0; i < len; i++) {
            if(arr[i] > arr[i + 1]){
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }
            if(i == len - 1){ //关键点:判断是否是最后一次比较
                i = -1;  //i重置为-1，随后for循环会自动++,因此下次比较时i值为0
                len--;   //比较次数递减1
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {29,10,14,37,14,2,8,1,7,6,5};
        sortDoubleFor(arr);
        System.out.println("--------------------------------------");
        sortOnlyOneFor(arr);
    }

}
