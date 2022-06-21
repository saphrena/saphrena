package com.saphrena.Sort;

import java.util.Arrays;

/**
 * @author 热河
 * @created 2022/5/27 16:22
 * @project saphrena
 * 1.先取出数列中的第一个数作为基准数
 * 2.将数列中比基准数大的数全部放在它的右边，比准数小的数全部放在它的左边
 * 3.然后在对左右两部分重复第二步，直到各区间只有一个数
 * @Description
 */
public class QuickSort {
    public static void resolve(int[] array, int left, int right) {
        //left数组的最小下标，right数组最大下标
        if (left > right) {                    //判断本次是否执行
            return;
        }
        int low = left;
        int high=right;
        int mid=array[low];                    //将数组第一个数定为基准

        while(low<high){
            while(low<high && array[high]>=mid) //从后往前，直到找到小于基准的数
                high--;
            array[low]=array[high];            //小数移动到前面
            while(low<high && array[low]<=mid)  //从前往后，直到找到大于基准的数
                low++;
            array[high]=array[low];            //大数移动到后面
        }

        array[low]=mid;                        //此时low在中间，将基准放入
        resolve(array,left,low-1);      //左数组递归
        resolve(array,low+1,right);      //右数组递归
    }

    public static void main(String[] args) {
        int[] arr = {6, 9, 6, 6, 8, 7, 10, 5, 1, 6};
        resolve(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
