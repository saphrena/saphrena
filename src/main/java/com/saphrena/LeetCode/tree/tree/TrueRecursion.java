package com.saphrena.LeetCode.tree.tree;

/**
 * @author saphrena
 * @description 递归实现二叉树前中后序遍历
 * @create 2022/7/18 018 21:05
 */


public class TrueRecursion {
    //二叉树定义
    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //前序
    public void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.value + "");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
        }

    //中序
    public void inOrderRecur(Node head){
        if(head == null){
            return;
        }
        preOrderRecur(head.left);
        System.out.println(head.value + "");
        preOrderRecur(head.right);
    }

    //后序
    public void posOrderRecur(Node head){
        if(head == null){
            return;
        }
        preOrderRecur(head.left);
        preOrderRecur(head.right);
        System.out.println(head.value + "");
    }
}