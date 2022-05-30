package com.saphrena.LeetCode;

/**
 * @author 数据组-热河
 * @created 2022/4/22 17:14
 * @project saphrena
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}

