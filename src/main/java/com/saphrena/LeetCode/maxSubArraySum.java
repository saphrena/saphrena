package com.saphrena.LeetCode;

/**
 * @author saphrena
 * @description 最大子数组和(动态规划问题)
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组
 * （子数组最少包含一个元素），返回其最大和。
 *
 * 动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
 * 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
 * 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
 * 每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
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