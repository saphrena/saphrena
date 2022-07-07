package com.saphrena.Java;

/**
 * @author saphrena
 * @description 二叉树
 * @create 2022/7/7 007 23:42
 */


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}