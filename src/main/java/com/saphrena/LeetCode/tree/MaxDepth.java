package com.saphrena.LeetCode.tree;

import com.saphrena.Java.TreeNode;

/**
 * @author saphrena
 * @description 二叉树最大深度
 * @create 2022/7/15 015 4:33
 *
 * 如果我们知道了左子树和右子树的最大深度 ll 和 rr，那么该二叉树的最大深度即为max(l,r)+1
 */


public class MaxDepth {
    public int maxDepth(TreeNode root) {
//        终止条件：当前节点为空
//        找出返回值：节点为空时说明高度为 0，所以返回 0
        if(root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    public int maxDepth1(TreeNode root) {
        return root == null ? 0 : Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;
    }
}