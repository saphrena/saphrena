package com.saphrena.LeetCode.arrays.array;

/**
 * @author saphrena
 * @description 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，
 * 使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * @create 2022/6/7 007 23:45
 */


public class RemoveDuplicates {
    public static void resolve (int[] nums) {
        if(nums == null || nums.length == 0){return;}
        int fast = 1;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
            fast++;
        }
        System.out.println(slow+1);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,4};
        resolve(nums);
    }
}