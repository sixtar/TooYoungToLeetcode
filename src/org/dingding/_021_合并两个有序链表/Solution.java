package org.dingding._021_合并两个有序链表;

/**
 * 原理就是虚拟头结点和合并有序数组/链表的逻辑（跟归并排序里的逻辑一致）
 */
public class Solution {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟头结点
        ListNode mergeDumbHead = new ListNode();
        ListNode curr = mergeDumbHead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr =  curr.next;
        }
        // 处理剩余元素
        if(l1 != null){
            curr.next = l1;
        } else if(l2 != null){
            curr.next = l2;
        }
        return mergeDumbHead.next;
    }
}
