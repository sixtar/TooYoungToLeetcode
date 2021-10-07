package org.dingding._029_两数相除;

/**
 * 一个是二分法一个是快速乘法
 * 使用long存储来避免判断溢出的问题
 */
public class Solution2 {

    public int divide(int dividend, int divisor) {
        // 都转成long
        long result = 0;
        int ddFlag = dividend > 0 ? 1 : -1;
        int drFlag = divisor > 0 ? 1 : -1;
        // 使用绝对值方便判断
        long absDd = ddFlag * dividend;
        long absDr = drFlag * divisor;
        // 结果肯定落在[0,absDd]之间，使用二分法
        long left = 0;
        long right = absDd;
        while(left < right){
            long mid = (left + right+1)>>1; // left + ((right-left)>>1) +1  这样可以避免溢出，不过此处是long类型存储无所谓了
            if(quickMulti(mid, absDr) <= absDd){
                left = mid;
            } else{
                right = mid-1;
            }

        }

        result = left*ddFlag*drFlag;
        // 判断是是否溢出
        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int) result;
    }

    /**
     * 正整数快速乘法
     * @param a
     * @param b
     * @return
     */
    private static long quickMulti(long a,long b){
        long result = 0;
        while(b > 0){
            // 最低位为1则加上a
            if((b & 1) == 1){
                result +=a;
            }
            // 被乘数b右移除以2，乘数a乘以2
            b >>= 1;
            a+=a;

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().divide(10, 3));

    }


}
