package com.saphrena.LeetCode.listNode;

/**
 * @author saphrena
 * @description 功能描述
 * @create 2022/6/22 022 23:59
 *
 * pre：指向当前节点的前一节点，用于反转链表；
 *
 * cur：指向当前节点，用于遍历整个链表；
 *
 * next：指向当前节点的后（下）一节点，用于在反转前，保留 cur 的下一节点，
 * 防止反转时，链表断开，无法找到 cur 后面的节点。
 *
 * 反转前： 1-->2-->3-->4
 * 反转后： 1<--2<--3<--4
 */





public class ReverseList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    //递归
    public ListNode reverseList1(ListNode head) {
        // 1. 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}