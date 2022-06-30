package com.saphrena.Java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author saphrena
 * @description 最小的 k个数
 * 解题思路
 * 3.最大堆
 * 2.快速排序（最高效）
 * 1.冒泡排序
 * 4.排序 + copy 数组
 * 5.桶排序
 * @create 2022/6/30 030 20:03
 */


public class GetLeastNumbers {
    //冒泡排序每轮将最小的移到前面，执行k轮即得到最小的k个数
    //时间复杂度O(k(n-k))
    public int[] resolveBubbleSort(int[] arr,int k){
        int len = arr.length;
        for (int i = 0; i < k; i++) {
            for(int j=len-1;j>i;j--){
                if(arr[j]<arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
        int[] res = new int[k];
        int i = 0;
        while(i<k){
            res[i] = arr[i];
            i++;
        }
        return res;
    }


        public int[] resolveQuickSort(int[] arr, int k) {
        if(arr==null || arr.length<=k)
            return arr;

        quicksort(arr, 0, arr.length-1, k);
        int[] res = new int[k];
        for(int i=0; i<k; i++)
            res[i] = arr[i];
        return res;
    }


    //快排在这道题中不用把整个数组进行排序，只需切分得到第k个数.最高效。
    // 则其左侧的k-1个数都小于第k个数，又侧的（n-k）个数都大于k，因此可以直接返回前k个数。
    //快速排序方法的时间复杂度O(n)（如果是整个数组都排序则是O(nlogn)），空间复杂度O(1)。
    public void quicksort(int[] arr, int start, int end, int k){
        int pivot_index = partition(arr, start, end);
        if(pivot_index==k)
            return;
        else if(pivot_index<k){
            quicksort(arr, pivot_index+1, end, k);
        }
        else{
            quicksort(arr, start, pivot_index-1, k);
        }
    }

    public int partition(int[] arr, int left, int right){
        int pivot = arr[left];

        while(left<right){
            while(left<right && arr[right]>pivot){
                right--;
            }
            if(left<right){
                arr[left++] = arr[right];
            }
            while(left<right && arr[left]<=pivot){
                left++;
            }
            if(left<right){
                arr[right--] = arr[left];
            }
            arr[left] = pivot;
        }
        return left;
    }



    //设置一个最大堆，存储当前最小的k个数。每次有新数字时，
    // 如果最大堆内数字数目小于k，则直接将新数字插入堆中；
    // 否则，将新数字与最大堆堆顶的值（即最小的k个数中的最大值）进行比较，
    // 如果小于最大堆堆顶值，则将最大堆堆顶值弹出，将新数字加入堆中。
    // 直到所有数字遍历完毕，最大堆中的k个数字即为数组中最小的k个数。
    //最大堆方法的时间复杂度O(nlogk)，空间复杂度O(k)。
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = {};
        if(arr==null || arr.length<=0 || k<=0)
            return res;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });

        for(int i=0; i<arr.length; i++){
            if(maxHeap.size()<k){
                maxHeap.add(arr[i]);
            }
            else{
                int temp = maxHeap.peek();
                if(temp>arr[i]){
                    maxHeap.poll();
                    maxHeap.add(arr[i]);
                }
            }
        }

        int i=0;
        res = new int[maxHeap.size()];
        for(Integer in : maxHeap){
            res[i++] = in;
        }
        return res;
    }



    //排序 + copy 数组

        public int[] getLeastNumbers3(int[] arr, int k) {
            int[] ret = new int[k];
            Arrays.sort(arr);
            for(int i=0; i<k; ++i){
                ret[i] = arr[i];
            }
            return ret;
        }



    //桶排序
        public int[] getLeastNumbers4(int[] arr, int k) {

            int[] cnt = new int[10001];
            int[] ret = new int[k];

            for(int x : arr){
                cnt[x] ++;
            }

            int retIndex = 0;
            for(int index=0; index<cnt.length; ++index){
                if(cnt[index] > 0){
                    int tmp = 0;
                    while(tmp < cnt[index] && retIndex < k){
                        ret[retIndex++] = index;
                        tmp++;
                    }
                }
                if(retIndex == k){
                    break;
                }
            }
            return ret;
        }


    public static void main(String[] args) {
         int[] arr = {1, 2, 3, 4, 5, 6};
         int k = 3;
         int[] res = new GetLeastNumbers().resolveBubbleSort(arr,k);
         int[] res1 = new GetLeastNumbers().resolveQuickSort(arr, k);
         int[] res2 = new GetLeastNumbers().getLeastNumbers(arr, k);
         int[] res3 = new GetLeastNumbers().getLeastNumbers3(arr, k);
         int[] res4 = new GetLeastNumbers().getLeastNumbers4(arr, k);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
        System.out.println(Arrays.toString(res3));
        System.out.println(Arrays.toString(res4));
    }

}