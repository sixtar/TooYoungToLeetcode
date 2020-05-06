package _013_Roman_to_Integer;

/**
 * 罗马数字转整形
 * Created by dzj on 2020.5.6.
 */
public class Solution1 {

    /**
     * 思路实际是寻找是否存在类似IX的字符,
     * 减去2(本来应该10-1的,但是按照顺序加,所以需要减两次1)或者其他数
     *
     * @param s 入参
     * @return 整形数
     */
    public int romanToInt(String s) {
        if (null == s || s.length() <= 0) {
            return 0;
        }
        // IV 4 IX 9 XL 40 XC 90 CD 400 CM 1000
        int result = 0;
        if (s.contains("IV")) {
            result -= 2;
        }
        if (s.contains("IX")) {
            result -= 2;
        }
        if (s.contains("XL")) {
            result -= 20;
        }
        if (s.contains("XC")) {
            result -= 20;
        }
        if (s.contains("CD")) {
            result -= 200;
        }
        if (s.contains("CM")) {
            result -= 200;
        }
        // 剩下的按照c从大到小顺序解析就行
        char[] chars = s.toCharArray();
        /*
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        */

        for (char aChar : chars) {
            if (aChar == 'M') {
                result += 1000;
            } else if (aChar == 'D') {
                result += 500;
            } else if (aChar == 'C') {
                result += 100;
            } else if (aChar == 'L') {
                result += 50;
            } else if (aChar == 'X') {
                result += 10;
            } else if (aChar == 'V') {
                result += 5;
            } else if (aChar == 'I') {
                result += 1;
            } else {
                result += 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String t = "LVIII";
        System.out.println("new Solution().romanToInt(t) = " + new Solution1().romanToInt(t));
    }

}
