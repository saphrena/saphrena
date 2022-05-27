package com.saphrena.Sort;

import java.util.Arrays;

/**
 * @author 数据组-热河
 * @date 2022/3/4
 * @Project saphrena
 */

public class InsertSort {
    public static void sort(int[] num) {
        int length = num.length;
        int insertNum;    //插入数
        for (int i = 1; i < length; i++) {  //插入次数
          insertNum= num[i];
          int j = i-1;   // 已排好序列的元素个数
             while(j>=0 && num[j] > insertNum){
                 num[j+1] = num[j]; //大的元素往后移动一格
                 j--;
             }
            num[j+1] = insertNum;  //将需要插入的数放在要插入的位置
        }
        System.out.println(Arrays.toString(num));
    }
    public static void main(String[] args) {
        int[] num = {29,10,14,37,14,2,8,1,7,6,5};
        sort(num);
    }
}
