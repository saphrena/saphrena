package com.saphrena.LeetCode.tree;

/**
 * @author saphrena
 * @description 功能描述
 * @create 2022/7/18 018 23:34
 */


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}