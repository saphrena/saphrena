package com.saphrena.LeetCode;

/**
 * @author saphrena
 * @description 买卖股票的最佳时机
 * @create 2022/6/20 020 22:59
 *
 * 给定一个数组 prices ，它的第i个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 找出给定数组中两个数字之间的最大差值（即，最大利润）。
 * 此外，第二个数字（卖出价格）必须大于第一个数字（买入价格）。
 */


public class MaxProfit {
    public int resolve(int[] arr){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        final int len = arr.length;
        for (int i = 0; i < len; i++) {
            if(arr[i] < minPrice){
                minPrice = arr[i];
            } else if(arr[i] - minPrice > maxProfit) {
                maxProfit = arr[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,9,2,4,5,78,9,2};
        int resolve = new MaxProfit().resolve(arr);
        System.out.println(resolve);
    }
}