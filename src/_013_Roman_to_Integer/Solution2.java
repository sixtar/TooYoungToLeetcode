package _013_Roman_to_Integer;

/**
 * 罗马数字转整形
 * Created by dzj on 2020.5.6.
 */
public class Solution2 {

    /**
     * 思路更接近问题本质,即从左到右,左边是否比当前数小,小则需要减一下左边的数
     * switch比hashMap要快
     *
     * @param s 入参
     * @return 整形数
     */
    public int romanToInt(String s) {
        if (null == s || s.length() <= 0) {
            return 0;
        }
        int result = 0;
        char[] chars = s.toCharArray();

        boolean isFirst = true;
        int pre = 0;
        for (char aChar : chars) {
            int cur = getIntByChar(aChar);
            result += cur;
            if(isFirst){
                isFirst = false;
           }else{
                if(pre < cur){
                    result -= pre*2;
                }
            }

            pre = cur;


        }
        return result;
    }


    private int getIntByChar(char c) {
        switch (c) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String t = "LVIII";
        System.out.println("new Solution().romanToInt(t) = " + new Solution2().romanToInt(t));
    }

}
