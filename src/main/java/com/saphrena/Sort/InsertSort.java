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
        int insertNum;
        for (int i = 0; i < length; i++) {
          insertNum= num[i];
          int j = i-1;
             while(j>=0 && num[j] > insertNum){
                 num[j+1] = num[j];
                 j--;
             }
            num[j+1] = insertNum;
        }
        System.out.println(Arrays.toString(num));
    }
    public static void main(String[] args) {
        int[] num = {29,10,14,37,14,2,8,1,7,6,5};
        sort(num);
    }
}
