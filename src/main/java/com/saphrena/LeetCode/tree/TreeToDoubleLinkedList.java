package com.saphrena.LeetCode.tree;

import com.saphrena.Java.TreeNode;

/**
 * @author saphrena
 * @description 二叉树转双向链表
 *
 * 二叉搜索树的特点：
 * 对于树上的任意节点，左子树节点小于根节点，右子树节点大于根节点。
 * 二叉搜索树中序遍历可以得到一个有序的序列。
 *
 * 求解思路：
 * 通过中序遍历来转换
 * 递归将左子树转换成双向链表；
 * 将根节点尾插到左子树链表的末尾；
 * 递归将右子树转成链表；
 * 将根节点头插到右子树链表前面。
 *
 * @create 2022/7/9 009 21:30
 */


public class TreeToDoubleLinkedList {
    public TreeNode Convert(TreeNode rootTree){
        if(rootTree == null){return null;}
        if(rootTree.left == null && rootTree.right == null){return null;}

        //递归将左子树转换成链表
        final TreeNode leftHead = Convert(rootTree.left);
        TreeNode leftTail = leftHead;

        //将根节点尾插到leftHead链表中(需先找到尾节点的位置再尾插)
        while (leftTail != null & leftTail.right != null){
              leftTail = leftTail.right;
        }
        if(leftHead != null){
            leftTail.right = rootTree;
            rootTree.left = leftTail;
        }

        //递归将右子树转换成链表
        final TreeNode rightHead = Convert(rootTree.right);
        if(rightHead != null){
            rootTree.right = rightHead;
            rightHead.left = rootTree;
        }
        //返回最终链表的头节点
        //若leftHead是空链表，应返回pRootOfTree
        return leftHead != null ? leftHead : rootTree;
    }
}