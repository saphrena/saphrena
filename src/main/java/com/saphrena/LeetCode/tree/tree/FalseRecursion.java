package com.saphrena.LeetCode.tree.tree;

import java.util.Stack;

/**
 * @author saphrena
 * @description 非递归实现二叉树前中后序遍历
 * @create 2022/7/18 018 21:05
 */


public class FalseRecursion {
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
        System.out.println("pre-order: ");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){ //直到栈为空
                stack.pop(); //弹出栈顶
                System.out.println(head.value + " ");
                if(head.right != null) {
                    stack.push(head.right);
                }
                if(head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    //中序
    public void inOrderRecur(Node head){
        System.out.println("in-order: ");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.value + "");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    //后序
    public void posOrderRecur(Node head){
        System.out.println("pos-order: ");
        if(head != null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            //每一个从s1中弹出来的节点都放在s2中
            while(!stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);
                if(head.left != null){
                    stack1.push(head.left);
                }
                if(head.right != null){
                    stack1.push(head.right);
                }
            }

            //从stack2中弹出节点依次打印
            while(!stack2.isEmpty()){
                System.out.println(stack2.pop().value + " ");
            }
        }
        System.out.println();
    }
}