package org.dingding._032_最长有效括号;

/**
 * 动态规划的解法
 * 因为最长匹配括号只要看当前的位置向前就行，所以一维dp数组即可
 * 看了题解 https://leetcode.cn/problems/longest-valid-parentheses/solution/dong-tai-gui-hua-si-lu-xiang-jie-c-by-zhanganan042/
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
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
        // 存储的是字符串i索引处作为匹配结尾的有效括号长度
        int[] dp = new int[s.length()];
        // 最大括号匹配的长度
        int max = 0;
        // 从1开始，因为dp[0]肯定为零
        for (int i = 1; i < s.length(); i++) {
            // 只有右括号才能作为有效括号的结尾
            if (s.charAt(i) == ')') {
                // 看i-1的位置是什么括号
                if (s.charAt(i - 1) == '(') {
                    // i和i-1匹配了，则看看i-2的位置
                    if (i - 2 > 0) {
                        dp[i] = 2/*当前i和i-1匹配*/ + dp[i - 2];
                    } else {
                        dp[i] = 2;
                    }
                } else { // 上一个也是右括号，那这个右括号位置匹配的值不能为零，否则计算没意义
                    if (dp[i - 1] > 0) {
                        // 判断i和它前面对应的位置是否匹配，可以用i-1的位置计算
                        int iLeftMatchIdx = i - dp[i - 1] - 1;
                        if (iLeftMatchIdx > 0 && s.charAt(iLeftMatchIdx) == '(') {
                            dp[i] = dp[i - 1] + 2;
                            // 容易漏掉的情形
                            // 但是可能出现 ()((()))的情形，iLeftMatchIdx前面还有匹配的括号串，需要加上
                            // 这个情形不是处理i-1位置的值能处理的，因为那时当前局部括号子串还未完全匹配
                            if (iLeftMatchIdx - 1 > 0) {
                                dp[i] = dp[iLeftMatchIdx - 1] + dp[i];
                            }
                        }


                    }

                }
            }

            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
