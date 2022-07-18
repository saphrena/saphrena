package com.saphrena.LeetCode.tree;

import com.saphrena.LeetCode.tree.tree.TrueRecursion;

/**
 * @author saphrena
 * @description 二叉树的最小深度
 * @create 2022/7/18 018 22:48
 */


public class MinDepth {
    public int resolve(TrueRecursion.Node head){
        if(head == null ){
            return 0;
        }
        return process(head,1);
    }

    //当前节点来到的节点是cur，深度为level
    //遍历cur子树
    public int process(TrueRecursion.Node cur , int level){
        if(cur.left == null && cur.right == null){
            return level;
        }
        int ans = Integer.MAX_VALUE;
        if(cur.left != null){
            return Math.min(process(cur.left,level+1),ans);
        }

        if(cur.right != null){
            return Math.min(process(cur.right,level+1),ans);
        }
        return ans;
    }
}