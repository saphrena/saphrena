package com.saphrena.LeetCode.listNode;


/**
 * @author saphrena
 * @description 合并两个有序链表
 * ListNode:链表是一种数据结构：由数据和指针构成，链表的指针指向下一个节点
 *
 * 终止条件：当两个链表都为空时，表示我们对链表已合并完成。
 * 如何递归：我们判断 l1 和 l2 头结点哪个更小，
 * 然后较小结点的 next 指针指向其余结点的合并结果。（调用递归）
 * @create 2022/6/15 015 0:41
 */



public class MergeTwoLists {

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1 == null){
            return  list2;
        } else if(list2 == null){
            return list1;
        } else if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
      }
    }
