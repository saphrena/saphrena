package com.saphrena.LeetCode;

/**
 * @author saphrena
 * @description 功能描述
 * @create 2022/6/23 023 21:49
 */


import java.util.Arrays;

/**
 *参考了快速排序的思想，快速排序首先要确定一个待分割的元素做中间点x，
 * 然后把所有小于等于x的元素放到x的左边，大于x的元素放到其右边。
 * 这里我们可以用0当做这个中间点，把不等于0(注意题目没说不能有负数)的放
 * 到中间点的左边，等于0的放到其右边
 * **/

public class MoveZeroes {
    public int[] moveZeroes(int[] nums) {
        if(nums==null) {
            return null;
        }
        //两个指针i和j
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
        return nums;
    }

    public int[] moveZeroes1(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] nums = {1,0,2,0};
        int[] ints = new MoveZeroes().moveZeroes1(nums);
        System.out.println(Arrays.toString(ints));
    }
}