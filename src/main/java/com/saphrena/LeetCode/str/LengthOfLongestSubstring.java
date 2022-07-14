package com.saphrena.LeetCode.str;

import java.util.HashMap;

/**
 * @author saphrena
 * @description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 * 滑动窗口解决
 * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
 * @create 2022/6/14 014 22:45
 */


public class LengthOfLongestSubstring {
    public static void resolve(String s){
        int len = s.length();
        if(len == 0) {return;}
        HashMap<Object, Integer> map = new HashMap<>();
        int max = 1, left = 0;

        for(int right = 0; right < len; right++){
            while(map.containsKey(s.charAt(right))){
                //left = Math.max(left,map.get(s.charAt(i))+1);  //从字符位置后一个才开始不重复
                map.remove(s.charAt(right));
                left++;
            }
            map.put(s.charAt(right),right);
            max = Math.max(max,right-left+1);   //无重复最长
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        String s  = "abcab";
        resolve(s);
    }
}