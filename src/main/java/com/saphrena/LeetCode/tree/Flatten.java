package com.saphrena.LeetCode.tree;


/**
 * @author saphrena
 * @description 二叉树展开为链表
 * @create 2022/7/18 018 23:32
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，
 * 其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */


public class Flatten {
    public void resolve(TreeNode root){
        if(root == null){
            return;
        }
        // 1. 先将左子树展开为链表
        resolve(root.left);
        // 2. 将右子树展开为链表
        resolve(root.right);
        // 将左子树迁移到右子树中
        TreeNode node = root.left;
        if(node != null){  // 如果左子树不为空
            // 3.1. 先找到左子树链表中的尾结点
            while (node.right != null){
                 node = node.right;
            }
            // 3.2. 将右子树插入到左子树的尾部结点
           node.right = root.right;


            // 3.3 将左子树换到右结点
            root.right = root.left;
            root.left = null;
        }
    }
}