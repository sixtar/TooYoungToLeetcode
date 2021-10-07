package org.dingding._019_remove_nth_from_end;

import java.util.Arrays;
import java.util.List;

/**
 * @author dzj
 */
public class Solution2 {

    /**
     * 单链表反转
     *
     * 链表中环的检测
     *
     * 两个有序的链表合并
     *
     * 删除链表倒数第 n 个结点
     *
     * 求链表的中间结点
     */

    public static class ListNode{

        int val;

        ListNode next;

        ListNode(){}

        ListNode(int val){
            this.val = val;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static int getLen(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        return null;
    }


    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(9, 8, 1, 3, 5, 0, 2);
        ListNode listNode = genLinkListByList(arr);
        printLinkList(listNode);
        ListNode reverseNode = reverseLinkList(listNode);
        printLinkList(reverseNode);

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

    // 单链表反转，思路是不断把后一个元素插到最开头
    public static ListNode reverseLinkList(ListNode head){
        ListNode first = head;

        while(head.next != null){
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = first;
            first = cur;
        }
        return first;

    }
}
