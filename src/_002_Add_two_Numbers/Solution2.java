package _002_Add_two_Numbers;

/**
 * 两个链表数组按位相加
 * 第二种方法:巧用三位运算符和判断语句
 * Created by dzj on 2019.9.10.
 */
public class Solution2 {


    /**
     * 第二种方法更简洁
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        //三个条件任意条件满足都会继续计算
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            //三元运算符分别判断
            int sum = ((l2 == null) ? 0 : l2.val)
                    + ((l1 == null) ? 0 : l1.val)
                    + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l2 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }

        return head.next;
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
