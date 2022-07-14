package com.saphrena.LeetCode.arrays.pointer;


/**
 * @author saphrena
 * @description
 * 分割数组(将数组三等分)
 *
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *
 * 1.分成相等的三分则意味着数组和一定为3的倍数,所以当sum的值不是散的倍数时,则一定为false;
 * 2.使用双指针分别从头尾访问并累加元素值,当leftsum和rightsum都为sum/3时,代表此时数组被平均分为3分,中间那份一定也是sum/3.
 * 3.当循环结束没有找到left和right的合适位置则代表不能
 * @create 2022/6/10 010 23:45
 */


public class ArraySplit {
    //方法1，返回Boolean
    public static boolean resolveReturnBoolean(int[] nums) {
        //1.分成和相等的三个部分则意味着和一定是3的倍数，如果不是直接返回false
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 3 != 0) {
            return false;
        }
        //2.使用双指针分别从头尾出发，加快速率
        int left = 0;
        int right = nums.length - 1;
        int leftSum = nums[left];
        int rightSum = nums[right];
        //循环将A中元素按左右指针分别求和
        //将left+1<right作为循环条件，若是left<right的，则不能保证一定是将数组分为3部分

        while (left < right - 1) {
            if (leftSum != sum / 3) {
                //左边不等于1/3，则更新left的值和左边sum的值
                left++;
                leftSum += nums[left];
            }
            if (rightSum != sum / 3) {
                //右边不等于1/3，则更新right的值和右边sum的值
                right--;
                right--;
                rightSum += nums[right];
            }
            //此时代表sum已经被分为和相等的三部分（中间部分肯定也为1/3）
            if (rightSum == sum / 3 && leftSum == sum / 3) {
                return true;
            }
        }
        //循环结束还没找到left和right合适的位置则代表不能平均分
        return false;
    }
    //方法2，返回下标
    public static void resolveReturnIndex(int[] nums) {
        //1.分成和相等的三个部分则意味着和一定是3的倍数，如果不是直接返回false
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 3 != 0) {
            return;
        }
        //2.使用双指针分别从头尾出发，加快速率
        int left = 0;
        int right = nums.length - 1;
        int leftSum = nums[left];
        int rightSum = nums[right];
        //循环将A中元素按左右指针分别求和
        //将left+1<right作为循环条件，若是left<right的，则不能保证一定是将数组分为3部分

        while (left < right - 1) {
            if (leftSum != sum / 3) {
                //左边不等于1/3，则更新left的值和左边sum的值
                left++;
                leftSum += nums[left];
            }
            if (rightSum != sum / 3) {
                //右边不等于1/3，则更新right的值和右边sum的值
                right--;
                rightSum += nums[right];
            }
            //此时代表sum已经被分为和相等的三部分（中间部分肯定也为1/3）
            if (rightSum == sum / 3 && leftSum == sum / 3) {
                System.out.println("左下标为：" + left);
                System.out.println("右下标为：" + right);
                return;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {0,2,1,-6,6,-7,9,1,2,0,1};
        boolean result = resolveReturnBoolean(nums);
        System.out.println("该数组是否可以三等分？" + result);
        resolveReturnIndex(nums);
    }
}
