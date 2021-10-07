package org.dingding._025_k个一组翻转链表;

import org.dingding.base.BaseListNodeSolution;

import java.util.Arrays;

/**
 * 链表翻转 虚拟头结点 递归
 * 链表翻转需要多练练
 */
public class Solution extends BaseListNodeSolution {

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null){
            return null;
        }
        // 用来判断接下来的元素够不够k个，不够则终止递归
        ListNode checkHead = head;
        int checkCount = k;
        while(checkHead != null && checkCount > 0){
            checkHead = checkHead.next;
            checkCount--;
        }

        // 递归终止条件 剩下不到k个元素
        if(checkCount != 0){
            return head;
        }

        // 递归调用,得到后续分组翻转后的子链
        ListNode afterLink = reverseKGroup(checkHead,k);
        // 翻转目前这k个元素
        ListNode dumbHead = new ListNode();
        dumbHead.next = head;
        ListNode curr = head.next;
        ListNode lastCurr = head;
        // 画一下 dumbHead currHead element element oldHead curr currAfter
        ListNode currHead = head;
        for(int j =0;j<k-1;j++){
            ListNode currAfter = curr.next;
            currHead = dumbHead.next;
            // 目的是把第二个元素插入到dumbHead之后
            lastCurr.next = currAfter;
            // curr后继指向currHead
            curr.next = currHead;
            // dumb后继指向curr
            dumbHead.next = curr;
            curr = currAfter;
        }
        // 和递归子链拼起来
        lastCurr.next = afterLink;

        return dumbHead.next;



    }

    public static void main(String[] args) {
        ListNode ori = Solution.genLinkListByList(Arrays.asList(1, 2, 3, 4,5));
        Solution.printLinkList(ori);
        ListNode after = new Solution().reverseKGroup(ori,3);
        Solution.printLinkList(after);
    }
}
