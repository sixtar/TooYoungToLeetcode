package org.dingding._032_最长有效括号;

import java.util.Stack;

/**
 * 思路不对，全是判断会有很多问题解决不了的
 */
public class ErrorSolution {

    public static void main(String[] args) {
        ErrorSolution solution = new ErrorSolution();
        String test1 = "(()"; //    2
        System.out.println(solution.longestValidParentheses(test1));
        String test2 = ")()())"; // 4
        System.out.println(solution.longestValidParentheses(test2));
        String test3 = "()(()"; // 2
        System.out.println(solution.longestValidParentheses(test3));
        String test4 = "()(())"; // 6
        System.out.println(solution.longestValidParentheses(test4));


    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int max = 0;
        int idx = 0;
        int nowCount = 0;
        Stack<Character> st = new Stack<>();
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (c == '(') {
                if (!st.isEmpty()) {
                    st.removeAllElements();
                    nowCount = 0;
                }
                st.push('(');

            } else if (c == ')') {
                // 从栈里拿比对，拿到则计数+2，否则技术清零（清零前记得比对大小）、栈也清零
                if (st.isEmpty()) {
                    if (nowCount > max) {
                        max = nowCount;
                    }
                    nowCount = 0;
                } else {
                    Character pop = st.pop();
                    if (pop == '(') { // 括号匹配
                        nowCount += 2;
                    } else {
                        if (nowCount > max) {
                            max = nowCount;
                            // nowCount = 0;
                        }
                        st.removeAllElements();
                        nowCount = 0;
                    }

                }


            } else {

            }
            idx++;

        }
        if (nowCount > max) {
            max = nowCount;
            nowCount = 0;
        }
        return max;

    }


}
