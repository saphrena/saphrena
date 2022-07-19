package com.saphrena.LeetCode.tree;

import java.util.LinkedList;

import java.util.Queue;


/**
 * @author saphrena
 * @description 二叉树反序列化
 * @create 2022/7/20 020 1:01
 */

//先序遍历
public class TreeReverseSerialization {
    public TreeNode resolve(String str){
        String[] strs = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            queue.offer(strs[i]);
        }
        return PreOrder(queue);
    }

    public TreeNode PreOrder(Queue<String> queue) {
        final String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(value));
        head.left = PreOrder(queue);
        head.right = PreOrder(queue);
        return head;
    }
}