package com.saphrena.LeetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author saphrena
 * @description 二叉树序列化（二叉树被记录成文件的过程）
 * 1、先序遍历
 * 2、按层遍历
 * @create 2022/7/20 020 0:52
 */

    // #表示节点为空
    //！表示一个值的结束
    //不标记！，序列化结果会有歧义
public class TreeSerialization {
    public String resolve(TreeNode head){
        if(head == null){
            return "#!";
        }
        String res = head.val + "!";
        res += resolve(head.left);
        res += resolve(head.right);
        return res;
    }




    //按层遍历
    public String resolve2(TreeNode head){
        if(head == null){
            return "#!";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String res = head.val + "!";
        queue.offer(head);

        while(!queue.isEmpty()){

            head = queue.poll();

            if(head.left != null){
                res += head.left.val + "!";
                queue.offer(head.left);
            } else {
                res += "#!";
            }

            if(head.right != null){
                res += head.right.val + "!";
                queue.offer(head.right);
            } else {
                res += "#!";
            }
        }
        return res;
    }
}