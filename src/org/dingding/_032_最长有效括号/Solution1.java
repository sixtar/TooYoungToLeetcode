package org.dingding._032_最长有效括号;

import java.util.Stack;

/**
 * 栈解法，参考题解写的，弹出左括号然后判断栈是否是空的那个地方比较难以理解
 * 形式上有双指针的影子？
 * 触发计算的点：
 * a.左括号弹出栈空了
 * b.左括号弹出后栈没空，此时计算的是局部的一块匹配子串(test2)，如果后面没有匹配的右括号，则局部匹配的就会断掉，但全部匹配的不一定(test2 test4)
 * https://leetcode.cn/problems/longest-valid-parentheses/solution/zhan-zui-jian-jie-yi-dong-de-dai-ma-cjav-xa7v/
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        String test1 = ")()())()()()"; //    4
        System.out.println(solution.longestValidParentheses(test1));
        String test2 = "()((())"; //    4
        System.out.println(solution.longestValidParentheses(test2));
        String test3 = "(()())"; //    6
        System.out.println(solution.longestValidParentheses(test3));
        String test4 = "()(())(())"; //    10
        System.out.println(solution.longestValidParentheses(test4));

    }

    public int longestValidParentheses(String s) {
        // 栈用来存储左括号的索引，而不是左括号，因为计算需要用到索引2
        Stack<Integer> st = new Stack<>();
        // 最大的长度
        int ans = 0;
        // 合法子串的可能左边开头
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.add(i);
            } else {
                if (!st.isEmpty()) {
                    // 当前右串找出匹配了
                    Integer popIdx = st.pop();
                    if (st.isEmpty()) { // 栈为空，子串(可能是最长子串的一部分)匹配告一段落，注意可能会继续匹配新的重新开始的括号组合，所以start没变更
                        ans = Math.max(ans, i - start + 1);
                    } else { // 针对的是当前是部分子串的问题，比如()((()或者()((())，这种局部最大长度是2或者4，计算就是当前i-下一个栈里左括号的索引
                        // 栈里还有左括号，如果后续还能继续匹配右括号，则计算的数值会更新，否则就会断在这里
                        // ans = Math.max(ans, i - st.peek()); 这个比较难懂，下面为等效写法
                        ans = Math.max(ans, i - popIdx + 1);
                    }
                } else { // 右串找不到匹配，合法子串开头重新计数。左串找不到匹配压在栈里没啥问题
                    start = i + 1;
                }
            }
        }
        return ans;
    }


}
