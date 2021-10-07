package org.dingding._029_两数相除;

/**
 * 这个方法会超时，肯定不行。。。
 */
public class Solution {

    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }
        // 唯一会溢出的情况，单独处理
        if((dividend == Integer.MIN_VALUE) && divisor == -1){
            return Integer.MAX_VALUE;
        }

        int ddFlag = dividend > 0?1:-1;
        int drFlag = divisor > 0?1:-1;
        int absDd = ddFlag * dividend;
        int absDr = drFlag * divisor;

        int r = 0;
        int tmp = absDr;
        while(tmp <= absDd){
            r++;
            tmp = tmp+absDr;
        }

        return r*ddFlag*drFlag;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divide(-7, -2));
        int ii = -2147483648;
        int dv = 2;
        System.out.println(ii / dv);
    }
}
