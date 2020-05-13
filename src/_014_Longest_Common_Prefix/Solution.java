package _014_Longest_Common_Prefix;

/**
 * 最长公共前缀
 * Created by dzj on 2020.5.13.
 */

public class Solution {

    /**
     * 目前是直接暴力法做的
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length <= 0) {
            return "";
        }
        // 找长度最小的字符串长度
        int maxLen = 0;
        boolean isFirst = true;
        for (String str : strs) {
            if (isFirst) {
                maxLen = str.length();
                isFirst = false;
            } else if (maxLen > str.length()) {
                maxLen = str.length();
            }
        }
        if (maxLen == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            char cur = 0;
            boolean isFirst2 = true;
            int innerCount = 0;
            for (String str : strs) {
                if (isFirst2) {
                    cur = str.charAt(i);
                    isFirst2 = false;
                    innerCount++;
                } else {
                    if (cur == str.charAt(i)) {
                        innerCount++;
                    } else {
                        break;
                    }
                }

            }
            if (innerCount == strs.length) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }


        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String[] arr = {"flower", "flow", "flight"};
        System.out.println(Solution.longestCommonPrefix(arr));
    }

}
