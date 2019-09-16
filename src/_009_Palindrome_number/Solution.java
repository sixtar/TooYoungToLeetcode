package _009_Palindrome_number;

/**
 * * 回文数字
 * Created by dzj on 2019.9.16.
 */
public class Solution {

    public boolean isPalindrome(int a) {
        //先判断是否是负数,如果是负数则返回false
        if (a < 0) {
            return false;
        }
        //div是数字的位数,比如2313的div是1000
        int div = 1;
        int tmp = a;

        //机制循环算出最高位的数量级
        while (tmp > 9) {
            div = div * 10;
            tmp = tmp / 10;
        }
        //循环对数字高位低位依次比对,两头不断削短
        //比如 1234321 削短为->23432->343
        while (a != 0) {
            //获取最高位数字
            int highPos = a / div;
            int lowPos = a % 10;
            if (highPos != lowPos) {
                return false;
            }
            //把头尾都削去(lowPos减不减无所谓,因为是整数除法)
            a = (a - div * highPos) / 10;
            // 头尾缩了两位,所以要除以100
            div = div / 100;
        }

        return true;
    }


    public static void main(String[] args) {
        int testInt = 1234321;
        System.out.println(new Solution().isPalindrome(testInt));
    }
}
