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


        //按层遍历
    public TreeNode resolve2(String str){
        String[] arrays = str.split("!");

        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        TreeNode head = generateTreeNodeByString(arrays[index++]);
        if(head != null){
            queue.offer(head);
        }
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
             node.left = generateTreeNodeByString(arrays[index++]);
             node.right = generateTreeNodeByString(arrays[index++]);
             if(node.left != null){
                 queue.offer(node.left);
             }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return head;
    }
    public TreeNode generateTreeNodeByString(String str){
        if(str.equals("#")){
            return null;
        }
        return new TreeNode(Integer.parseInt(str));
    }
}