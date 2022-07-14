package com.saphrena.LeetCode.arrays.array;

/**
 * @author saphrena
 * @description 最大子数组和(动态规划问题)
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组
 * （子数组最少包含一个元素），返回其最大和。
 *
 * 动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
 * 如果 sum > 0，则说明 sum 对结果(num)有增益效果，则 sum 保留并加上当前遍历数字
 * 如果 sum <= 0，则说明 sum 对结果(num)无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
 * 每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
 * @create 2022/6/15 015 23:26
 */


public class maxSubArraySum {
    public int resolve(int[] nums){
        int res = nums[0];
        int curSum = 0;
        for (int num : nums) {
            if(curSum > 0 ){    //可改为 if(curSum + num > num)
                curSum += num;
            } else{
                curSum = num;
            }
            res = Math.max(res, curSum);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = new maxSubArraySum().resolve(nums);
        System.out.println(result);
    }
}