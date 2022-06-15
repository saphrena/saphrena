package com.saphrena.LeetCode;

/**
 * @author saphrena
 * @description 最大子数组和(动态规划问题)
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组
 * （子数组最少包含一个元素），返回其最大和。
 * @create 2022/6/15 015 23:26
 */


public class maxSubArraySum {
    public static void resolve(int[] nums){
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if(sum + num > num){    //可改为 if(sum > 0)
                sum += num;
            } else{
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        System.out.println("该数组的最大连续子数组的和为：" + ans);
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        resolve(nums);
    }
}