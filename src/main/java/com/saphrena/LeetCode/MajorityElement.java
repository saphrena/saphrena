package com.saphrena.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author saphrena
 * @description 多数元素
 * @create 2022/7/12 012 23:19
 */


public class MajorityElement {
    public Map<Integer,Integer> resolveOne(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if(!map.containsKey(num)){
                map.put(num,1);
            }else {
                map.put(num,map.get(num)+1);
            }
        }
        return map;
    }

    public int resolveTwo(int[] nums){
        final Map<Integer, Integer> integerMap = resolveOne(nums);
        Map.Entry<Integer, Integer> majorityEntry = null;
        for(Map.Entry<Integer,Integer> enter: integerMap.entrySet()){
            if(majorityEntry == null || enter.getValue() > majorityEntry.getValue()){
                majorityEntry = enter;
            }
        }
        return majorityEntry.getKey();
    }

    public int resolveThree(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement(int[] nums) {
        //假设第一个元素的票数
        int count = 1;
        //假设第一个元素为当选人
        int candidate = nums[0];
        for(int i=0;i<nums.length; i++){
            //如果数组遍历过程中，有元素和当选人元素一样，就加一
            if(nums[i] == candidate){
                count++;
            }else{
                //如果没有就减一
                count--;
            }
            //如果票数为0的话就更换当选人
            if(count == 0){
                //更换当选人
                candidate = nums[i];
                //票数重新置为1
                count = 1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,2,3};
        final int res = new MajorityElement().resolveTwo(nums);
        final int res1 = new MajorityElement().resolveThree(nums);
        final int res2 = new MajorityElement().majorityElement(nums);
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
    }
}