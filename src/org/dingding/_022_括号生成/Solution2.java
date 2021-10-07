package org.dingding._022_括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分递归和剪枝
 */
public class Solution2 {

    public List<String> generateParenthesis(int n) {

        java.util.List<java.lang.String> r = new ArrayList<>();
        concatNextPar("", 0, 0, n, r);

        return r;
    }

    // left right为左右括号个数的计数
    private void concatNextPar(String curStr, int left, int right, int n, List<String> r) {
        // 递归剪枝判断，已经存在的右括号如果比左括号多就说明不合法了
        if (right > left || left > n || right > n) {
            return;
        }
        // 递归终止条件
        if (left == n && right == n) {
            r.add(curStr);
        }

        concatNextPar(curStr + "(", left + 1, right, n, r);
        concatNextPar(curStr + ")", left, right + 1, n, r);

    }


    public static void main(String[] args) {
        System.out.println(new Solution2().generateParenthesis(3));
    }
}
