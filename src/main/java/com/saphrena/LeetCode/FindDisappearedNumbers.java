package com.saphrena.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author saphrena
 * @description  找到所有数组中消失的数字
 * @create 2022/7/15 015 3:58
 *
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 */


public class FindDisappearedNumbers {
    public static List<Integer> resolve(int[] nums) {
        List<Integer> res = new ArrayList<>();
        final int len = nums.length;
        final boolean[] booleans = new boolean[len + 1];
        for (int num : nums) {
            booleans[num] = true;
        }
        for(int i = 1;i<=len;i++){
            if(!booleans[i]){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(nums.length);
        final List<Integer> resolve = resolve(nums);
        System.out.println(resolve);

    }
}