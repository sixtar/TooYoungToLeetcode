package org.dingding._024_两两交换链表中的节点;

import org.dingding.base.BaseListNodeSolution;

import java.util.Arrays;

/**
 * 递归解法
 * 找终止条件：本题终止条件很明显，当递归到链表为空或者链表只剩一个元素的时候，没得交换了，自然就终止了。
 * 找返回值：返回给上一层递归的值应该是已经交换完成后的子链表。
 * 单次的过程：因为递归是重复做一样的事情，所以从宏观上考虑，只用考虑某一步是怎么完成的。我们假设待交换的俩节点分别为head和next，next的应该接受上一级返回的子链表(参考第2步)。就相当于是一个含三个节点的链表交换前两个节点，就很简单了，想不明白的画画图就ok。
 */
public class Solution2 extends BaseListNodeSolution {

    public ListNode swapPairs(ListNode head) {
        // 递归终止条件
        if(head == null || head.next == null){
            return head;
        }

        // 递归子链结果,传入下下一个元素
        ListNode afterLink = swapPairs(head.next.next);
        // 交换head和head.next
        ListNode first = head;
        ListNode second = head.next;
        // 第二个元素的next引用先更新
        second.next = first;
        first.next = afterLink;
        // 返回新的子链的头结点
        return second;
    }

    public static void main(String[] args) {
        ListNode ori = Solution2.genLinkListByList(Arrays.asList(1, 2, 3, 4));
        Solution2.printLinkList(ori);
        ListNode after = new Solution2().swapPairs(ori);
        Solution2.printLinkList(after);
    }
}
