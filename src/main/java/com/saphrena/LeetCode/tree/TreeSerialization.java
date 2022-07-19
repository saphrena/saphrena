package com.saphrena.LeetCode.tree;

/**
 * @author saphrena
 * @description 二叉树序列化（二叉树被记录成文件的过程）
 * 先序遍历
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
}