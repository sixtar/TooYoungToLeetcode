package org.dingding.base;


import org.dingding._023_合并k个升序链表.Solution;

import java.util.List;

public class BaseListNodeSolution {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public BaseListNodeSolution(){

    }

    public static ListNode genLinkListByList(List<Integer> l){
        ListNode head = new ListNode(l.get(0));
        ListNode cur = head;
        for(int i=1;i<l.size();i++){
            cur.next = new ListNode(l.get(i));
            cur = cur.next;
        }
        return head;
    }


    public static void printLinkList(ListNode head){
        StringBuilder sb = new StringBuilder();
        sb.append(head.val);
        while(head.next != null){
            head = head.next;
            sb.append(" "+head.val);
        }
        System.out.println(sb);
    }
}
