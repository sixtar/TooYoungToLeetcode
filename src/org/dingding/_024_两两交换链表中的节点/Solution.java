package org.dingding._024_两两交换链表中的节点;

import org.dingding.base.BaseListNodeSolution;

import java.util.Arrays;

/**
 * 虚拟头结点解法
 */
public class Solution extends BaseListNodeSolution {

    public ListNode swapPairs(ListNode head) {

        ListNode dumpHead = new ListNode();
        dumpHead.next = head;
        ListNode curr = dumpHead;
        while(curr.next != null && curr.next.next != null){
            ListNode suffix = curr.next.next.next;
            ListNode prefix = curr;
            ListNode firstEle = curr.next;
            ListNode secondEle = curr.next.next;
            // 第二个元素指向第一个元素
            secondEle.next = firstEle;
            // 第一个元素指向后节点
            firstEle.next = suffix;
            // 前节点指向第二个元素
            prefix.next = secondEle;

            // 当前节点变为第一个元素
            curr = firstEle;
        }

        return dumpHead.next;
    }

    public static void main(String[] args) {
        ListNode ori = Solution.genLinkListByList(Arrays.asList(1, 2, 3, 4));
        Solution.printLinkList(ori);
        ListNode after = new Solution().swapPairs(ori);
        Solution.printLinkList(after);
    }

}
