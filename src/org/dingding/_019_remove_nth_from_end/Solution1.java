package org.dingding._019_remove_nth_from_end;

/**
 * @author dzj
 */
public class Solution1 {

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

    // 注意是单向链表，不是双向链表
    // 知识点
    //  - 哑结点 主要是处理如果被删除的元素是头结点的问题
    //  - 双指针减少一次循环
    // 还是需要遍历两次，第一次获得长度
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        int len = getLen(head);
        if(n > len){
            return null;
        }

        ListNode curr = dummy;
        for(int j=0; j < len; j++){

            if(j >= len - n){
                curr.next = curr.next.next;
                break;
            }

            curr = curr.next;

        }

        return dummy.next;

    }



    public static void main(String[] args) {

        ListNode ele5 = new ListNode(5);
        ListNode ele4 = new ListNode(4, ele5);
        ListNode ele3 = new ListNode(3, ele4);
        ListNode ele2 = new ListNode(2, ele3);
        ListNode ele1 = new ListNode(1, ele2);

        ListNode listNode1 = new Solution1().removeNthFromEnd(ele1, 2);
        System.out.println(listNode1);
        ListNode listNode2 = new Solution1().removeNthFromEnd(ele1, 5);
        System.out.println(listNode2);



    }


}
