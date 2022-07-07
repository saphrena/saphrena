package com.saphrena.LeetCode;


import com.saphrena.Java.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;


/**
 * @author saphrena
 * @description 二叉搜索树中第k小元素
 * @create 2022/7/8 008 0:02
 */

/**解法1：树的遍历 + 排序
 * 朴素的做法是先对二叉树进行一次完整遍历，将所有节点存入列表中，最后对列表排序后返回目标值。
 * **/
public class KthSmallest {
    List<Integer> list = new ArrayList<>();
    public int resolve(TreeNode root, int k){
        addList(root);
        Collections.sort(list);
        //  Collections.sort()默认升序
        //  降序：Collections.sort(List<Integer>, Collections.reverseOrder());
        return list.get(k-1);
    }
    public void addList(TreeNode root){
        if(root == null)return;
        list.add(root.val);
        addList(root.left);
        addList(root.right);
    }




 /** 解法2：中序遍历
  * 二叉搜索树的中序遍历是有序的，因此我们只需要对二叉搜索树执行中序遍历，并返回第k小的值即可
  * 二叉树的中序遍历即按照访问左子树——根结点——右子树的方式遍历二叉树；
  * 在访问其左子树和右子树时，我们也按照同样的方式遍历；直到遍历完整棵树
  * 二叉搜索树的中序遍历是按照键增加的顺序进行的
  * **/

 public int resolve1(TreeNode root, int k) {
     Deque<TreeNode> ad = new ArrayDeque<>(); //双端队列
     while (root != null || !ad.isEmpty()) {
         while (root != null) {
             ad.addLast(root); //顺时针方向插入
             root = root.left;
         }
         root = ad.pollLast(); //尾端移除元素
         if (--k == 0) return root.val;
         root = root.right;
     }
     return -1; // never
 }

 /** 解法3：中序遍历 **/
 public int resolve2(TreeNode root, int k) {
     Deque<TreeNode> stack = new ArrayDeque<>();
     while (root != null || !stack.isEmpty()) {
         while (root != null) {
             stack.push(root);
             root = root.left;
         }
         root = stack.pop();
         --k;
         if (k == 0) {
             break;
         }
         root = root.right;
     }
     return root.val;
 }

}