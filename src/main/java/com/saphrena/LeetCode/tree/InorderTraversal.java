package com.saphrena.LeetCode.tree;

import com.saphrena.Java.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author saphrena
 * @description 二叉树的中序遍历
 * @create 2022/7/15 015 4:51
 *
 * 递归
 * 左---根---右
 * 定义 inorder(root) 表示当前遍历到root 节点的答案，那么按照定义，
 * 我们只要递归调用 inorder(root.left) 来遍历root 节点的左子树，
 * 然后将 root 节点的值加入答案，再递归调用inorder(root.right)
 * 来遍历root 节点的右子树即可，递归终止的条件为碰到空节点
 *
 */


public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res); //左
        res.add(root.val);  // 根
        inorder(root.right, res); //右
    }
}