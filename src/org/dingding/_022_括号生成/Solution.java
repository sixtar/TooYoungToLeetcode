package org.dingding._022_括号生成;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 思路是递归对了，但是没想到剪枝的条件，所以每种情况都跑了一遍，
 * solution2参考题解做一下剪枝判断，有了剪枝判断，就不用单独写一个判断是否有效的方法了
 */
public class Solution {


    public List<String> generateParenthesis(int n) {

        int left = n, right = n;
        List<String> r = new ArrayList<>();
        concatNextPar("", true, left, right, r);

        return r;
    }

    private void concatNextPar(String curStr, boolean nextLeft, int left, int right, List<String> r) {
        // 递归终止条件
        if (left == 0 && right == 0) {
            if (checkStrValid(curStr)) {
                r.add(curStr);
            }
        }

        if (nextLeft && left > 0) {
            curStr = curStr + "(";
            if(left >0){
                concatNextPar(curStr, true, left - 1, right, r);
            }
            if(right > 0){
                concatNextPar(curStr, false, left - 1, right, r);
            }


        } else if(!nextLeft) {
            curStr = curStr + ")";
            if(left > 0){
                concatNextPar(curStr, true, left, right - 1, r);
            }
            if(right > 0){
                concatNextPar(curStr, false, left, right - 1, r);
            }

        }

    }

    private boolean checkStrValid(String curStr) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < curStr.length(); i++) {
            char c = curStr.charAt(i);
            if ('(' == c) {
                st.push(c);
                continue;
            }
            if (')' == c) {
                if (st.isEmpty()) {
                    return false;
                }
                Character pop = st.pop();
                if (pop != '(') {
                    return false;
                }
            }


        }
        if (!st.isEmpty()) {
            return false;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }


}
