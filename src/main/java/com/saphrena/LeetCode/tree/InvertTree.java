package com.saphrena.LeetCode.tree;

/**
 * @author saphrena
 * @description 反转二叉树
 * @create 2022/6/23 023 21:37
 *
 * 从根节点开始，递归地对树进行遍历，从叶子节点先开始翻转，
 * 最后只需要交换两棵子树的位置，即可完成整棵子树的翻转。
 */


public class InvertTree {
    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }



}