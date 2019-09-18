package _008_String_to_integer;

/**
 * 经典问题:字符串数字转整形数字 atoi
 * 考察符号 非数字字符(空格或字母) 溢出等情况的处理
 * Created by dzj on 2019.9.18.
 */
public class Solution {

    /**
     * 参照leetcode讨论区里比较完善的不使用相关库的做法
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {

        char[] ch = str.toCharArray();
        int len = ch.length;
        //数字的位数
        int size = 0;
        boolean positive = true;
        // 判断符号位是否已经出现过
        boolean signSeen = false;
        boolean isDigit = false;
        // 确定数字位数
        for (int i = 0; i < len; i++) {
            char cur = ch[i];
            isDigit = cur - '0' >= 0 && cur - '0' <= 9;
            // 如果遇到过符号,但是当前位不是数字则结束循环
            //这个主要是处理"++100"这个情况的,没有这段代码,也能通过
            if (signSeen && !isDigit) {
                break;
            }

            // 这一块注释中的做法判断不清晰,其实分开size是否为0两种分别去判断比较好
            //一个数字还没有的情况
            if (size == 0) {
                //跳过开头的空格
                if (cur == ' ') {
                    // 什么也不做
                } else if (cur == '-') {
                    //负数
                    positive = false;
                    signSeen = true;
                } else if (cur == '+') {
                    //正数,其实这个判断可以省掉
                    positive = true;
                    signSeen = true;
                } else if (isDigit) {
                    //如果是数字,直接存储到当前数组的前置位置
                    ch[size++] = cur;
                } else {
                    //不是数字,且size=0,则跳出循环
                    break;
                }
            } else {
                //size大于零的情况
                if (isDigit) {
                    //是数字,则直接存储到当前数组的前置位置
                    ch[size++] = cur;
                } else {
                    //不是数字,跳出循环
                    break;
                }

            }

            //原始的答案里的这块判断
           /* if (size == 0 && ch[i] == ' ') {
                //don't do anything 跳过开头的空格
            } else if (size == 0 && ch[i] == '-') {
                //判断是否为负号
                positive = false;
            } else if (size == 0 && ch[i] == '+') {
                ////判断是否为正号,其实这个判断可以省略
                positive = true;
            } else if (size == 0 && ch[i] != ' ' && ch[i] != '+') {
                if (isDigit) {
                    ch[size++] = ch[i];
                } else {
                    break;
                }
            } else if (size > 0 && isDigit) {
                ch[size++] = ch[i];
            } else if (size > 0 && !isDigit) {
                break;
            }*/
        }

        if (size == 0) {
            return 0;
        }


        long result = 0;
        // 拼接为数字和判断是否溢出
        for (int i = 0; i < size; i++) {
            result = (ch[i] - '0') + (result * 10);

            if (positive && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (!positive && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

        }

        if (!positive) {
            result *= -1;
        }

        //long转换为int返回
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("  +100abc0918"));
    }
}
