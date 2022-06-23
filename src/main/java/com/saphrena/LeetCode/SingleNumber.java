package com.saphrena.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author saphrena
 * @description 只出现一次的数据
 *
 *
 * 任何数和 0 做异或运算，结果仍然是原来的数
 * 两数相同异或为0，两数不相同异或为1
 * @create 2022/6/23 023 20:27
 */


public class SingleNumber {

    // 此为HashSet解法
    public int resolve1(int[] nums) {
        // 使用 HashSet 存储出现的数字
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                set.remove(nums[i]);
            }
        }
        return set.iterator().next();
    }



    // HashMap解法
    public int resolve2(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()==1)return entry.getKey();
        }
        return 0;
    }


    public int singleNumber(int[] nums){
        int res = 0 ;
        for(int num: nums){
            res ^= num;
        }
        return res;
    }




    public static void main(String[] args) {
         int[] arr = {2,2,1};
         int res1 = new SingleNumber().resolve1(arr);
         int res2 = new SingleNumber().resolve2(arr);
         int res3 = new SingleNumber().singleNumber(arr);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}