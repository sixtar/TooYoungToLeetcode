package _3_Longest_substring_without_repeating_characters;

/**
 * Created by dzj on 2019.9.10.
 */
public class Solution {


    /**
     * 思路:定义一个128大小的boolean数组,使用索引对应英文字母的ascii码,这样来查询是否存在
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int n = s.length();
        //布尔数组用来存储子串字符是否存在
        boolean[] used = new boolean[128];
        int max = 0;
        while (right < n) {
            if (used[s.charAt(right)] == false) {
                used[s.charAt(right)] = true;
                right++;
            } else { //存在之前放进去一样的字符
                max = Math.max(max, right - left);
                //left比rigth小 并且 left和right没指到相同的字符
                while (left < right && s.charAt(right) != s.charAt(left)) {
                    //之前字符位置的地方要置为false
                    used[s.charAt(left)] = false;
                    left++;
                }
                left++;
                right++;
            }
        }
        //边界情况:假如一直没有重复的 或者说从某个子串开始一直没有重复的一直到结尾
        max = Math.max(max, right - left);
        return max;

    }


    public static void main(String[] args) {
        int result = new Solution().lengthOfLongestSubstring("abcdbeb");
        //预期结果应该是4
        System.out.println("result: " + result);

    }
}
