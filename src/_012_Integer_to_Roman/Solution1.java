package _012_Integer_to_Roman;

/**
 * 整形数转罗马
 * Created by dzj on 2020.5.7.
 */
public class Solution1 {

    /**
     * 只会暴力解决...结果发现这居然是贪心...
     * 贪心是局部最优,不过目前看来贪心很难适用大部分情况
     * 还有一种直接个十百位进行数组替换没意思,不写了
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num >= 1000) {
                sb.append("M");
                num -= 1000;
                continue;
            }
            if (num >= 900) {
                sb.append("CM");
                num -= 900;
                continue;
            }
            if (num >= 500) {
                sb.append("D");
                num -= 500;
                continue;
            }
            if (num >= 400) {
                sb.append("CD");
                num -= 400;
                continue;
            }
            if (num >= 100) {
                sb.append("C");
                num -= 100;
                continue;
            }
            if (num >= 90) {
                sb.append("XC");
                num -= 90;
                continue;
            }
            if (num >= 50) {
                sb.append("L");
                num -= 50;
                continue;
            }
            if (num >= 40) {
                sb.append("XL");
                num -= 40;
                continue;
            }
            if (num >= 10) {
                sb.append("X");
                num -= 10;
                continue;
            }
            if (num >= 9) {
                sb.append("IX");
                num -= 9;
                continue;
            }
            if (num >= 5) {
                sb.append("V");
                num -= 5;
                continue;
            }
            if (num >= 4) {
                sb.append("IV");
                num -= 4;
                continue;
            }
            while (num > 0) {
                sb.append("I");
                num--;
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        //int i = 1994;
        int i = 20;
        System.out.println("new Solution().intToRoman(i) = " + new Solution1().intToRoman(i));
    }
}
