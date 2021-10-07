package org.dingding._023_合并k个升序链表;

import org.dingding._019_remove_nth_from_end.Solution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 递归去做
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int curIdx = 0;
        ListNode curr = lists[0];

        ListNode ln = reverseMerge(curr, lists, curIdx + 1);

        return ln;


    }

    private ListNode reverseMerge(ListNode old, ListNode[] lists, int toMergerIdx) {
        if (toMergerIdx >= lists.length) {
            return old;
        }
        // 合并curr和toMergerIdx
        ListNode toMerge = lists[toMergerIdx];
        ListNode dumpHead = new ListNode();
        ListNode currNode = dumpHead;
        while (old != null && toMerge != null) {
            if (old.val <= toMerge.val) {
                currNode.next = old;
                old = old.next;
            } else {
                currNode.next = toMerge;
                toMerge = toMerge.next;
            }
            currNode = currNode.next;

        }
        // 处理剩余元素
        if (old != null) {
            currNode.next = old;
        }
        if (toMerge != null) {
            currNode.next = toMerge;
        }

        return reverseMerge(dumpHead.next, lists, toMergerIdx+1);

    }

    // 每次取各个链表里最小的元素，然后下次还从这个链表里取的思路实现好复杂。。先废弃
    public ListNode mergeKLists_001(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int n = lists.length;

        // 虚拟头结点
        ListNode headNode = new ListNode();
        // 存各个链表索引的数组
        int[] idxArr = new int[n];
        int curListNode = 0;

        return null;
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

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 4, 5);
        List<Integer> l2 = Arrays.asList(1, 3, 4);
        List<Integer> l3 = Arrays.asList(2,6);
        List<ListNode> lists = new ArrayList<>();
        ListNode h1 = Solution.genLinkListByList(l1);
        lists.add(h1);
        ListNode h2 = Solution.genLinkListByList(l2);
        lists.add(h2);
        ListNode h3 = Solution.genLinkListByList(l3);
        lists.add(h3);
        Solution.printLinkList(new Solution().mergeKLists(lists.toArray(new ListNode[0])));
    }

}
