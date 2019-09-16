package _002_Add_two_Numbers;

/**
 * 两个链表数组按位相加
 * 第一种方法:简单粗暴法
 * Created by dzj on 2019.9.10.
 */
public class Solution1 {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //入参校验
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        //结果的头部节点
        ListNode dummy = new ListNode(0);
        //节点当前位置
        ListNode currNode = dummy;
        //默认进位置为0
        int carry = 0;
        //l1和l2都还没到结尾的情况下
        while (l1 != null && l2 != null) {
            //先计算l1,l2,carry累加的结果
            int addRslt = l1.val + l2.val + carry;
            //计算结果链表当前位的值
            int cVal = addRslt % 10;
            //计算结果链表当前位置的进位值
            carry = addRslt / 10;
            ListNode aRsltNode = new ListNode(cVal);
            currNode.next = aRsltNode;
            currNode = aRsltNode;
            l2 = l2.next;
            l1 = l1.next;
        }
        // l2提前完成的情况下
        while (l1 != null) {
            //l1和进位计算累加值
            int addRslt = l1.val + carry;
            //计算结果链表当前节点的值
            int cVal = addRslt % 10;
            //计算进位
            carry = addRslt / 10;
            ListNode aRsltNode = new ListNode(cVal);
            currNode.next = aRsltNode;
            currNode = aRsltNode;
            l1 = l1.next;
        }

        //l1提前完成的情况下
        while (l2 != null) {
            //l2和进位计算累加值
            int addRslt = l2.val + carry;
            //计算结果链表当前节点的值
            int cVal = addRslt % 10;
            //计算进位
            carry = addRslt / 10;
            ListNode aRsltNode = new ListNode(cVal);
            currNode.next = aRsltNode;
            currNode = aRsltNode;
            l2 = l2.next;
        }
        //注意最后还有个进位要处理
        if (carry != 0) {
            currNode.next = new ListNode(carry);
        }
        //跳过dummy节点返回链表
        return dummy.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static void printListNode(ListNode head) {
        StringBuilder sb = new StringBuilder("Node: ");
        if (head != null) {
            sb.append(head.val);
            while (head.next != null) {
                sb.append("->" + head.next.val);
                head = head.next;
            }
        } else {
            sb.append("EMPTY!");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        // l1 2->4->3
        ListNode l1Head = new ListNode(2);
        l1Head.next = new ListNode(4);
        l1Head.next.next = new ListNode(3);
        //l2 5->6->4
        ListNode l2Head = new ListNode(5);
        l2Head.next = new ListNode(6);
        l2Head.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(l1Head, l2Head);

        //输出结果 预期应该为Node: 7->0->8
        printListNode(listNode);

    }
}
