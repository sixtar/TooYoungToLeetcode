package _007_Reverse_integer;

/**
 * Created by dzj on 2019.9.15.
 */
public class Solution {

    /**
     * 主要考虑两个问题:
     * 1.是否溢出:反过来算一下数值是否一样
     * 2.正数负数是否需要单独处理:不需要
     * 其他: 一开始以为可以用递归来做,试了下不行...
     *
     * @return 反转的结果, 如果溢出则返回0
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            //现在位置的数字
            int curNum = x % 10;
            int newRev = rev * 10 + curNum;
            //判断用新值计算出的rev和原来的rev一不一样,不一样就是数据溢出了
            //判断是否溢出还有一种方法是判断乘以10之前原来rev大小和Integer.MAX_VALUE/10或Integer.MIN_VALUE/10的关系
            // 以及个位数和7或-8的关系(因为int的上下届的个位数分别是7和8(负数))
            if ((newRev - curNum) / 10 != rev) {
                return 0;
            }
            rev = newRev;
            x = x / 10;
        }

        return rev;
    }

    public static void main(String[] args) {
        int testNum = -123;
        //预期 -321
        System.out.println(new Solution().reverse(testNum));
    }

}
