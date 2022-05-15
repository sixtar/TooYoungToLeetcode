package org.dingding._030_串联所有单词的字串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 利用单词长度是相同的，则每个子串的长度是一定的来遍历每个子串
 * 再利用两个hashMap遍历中间子串的每个单词的匹配情况
 * <p>
 * 另一种类似kmp的优化算法太难了。。
 * 实际生产中应该会把所有组合提前生成（递归？）预置在hashmap中？
 *
 * @author dzj
 * @since 2021/10/8
 */
public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {

        if (s == null || s.length() == 0 || words == null || words.length <= 0) {
            return new ArrayList<>();
        }
        // 单个单词的长度是固定的
        int wordLen = words[0].length();
        int wordsNum = words.length;
        // 预设组合子串的长度是固定的
        int subStrLen = wordLen * wordsNum;
        // 子串超过s长度就没啥对比必要
        int sLen = s.length();
        if (subStrLen > sLen) {
            return new ArrayList<>();
        }
        // 原始统计字符串的map
        HashMap<String, Integer> statMap = new HashMap<>();
        for (String w : words) {
            Integer num = statMap.get(w);
            if (num == null) {
                num = 1;
            } else {
                num += 1;
            }
            statMap.put(w, num);
        }

        List<Integer> result = new ArrayList<>();

        // 开始匹配子串的大循环
        outside:
        for (int i = 0; i < sLen - subStrLen + 1; i++) {
            // 以上面hashmap的key作为基准来匹配
            // 使用子串匹配就行了，不用逐个字符。。
            // 原数组总共wordsNum个单词
            // 每个去重单词包含情况
            HashMap<String, Integer> hasMap = new HashMap<>();
            for (int cur = 0; cur < wordsNum; cur++) {
                String curWord = s.substring(i + cur * wordLen, i + (cur + 1) * wordLen);
                if (statMap.containsKey(curWord)) {
                    Integer hasNum = hasMap.get(curWord);
                    if (hasNum == null) {
                        hasNum = 1;
                    } else {
                        hasNum += 1;
                    }
                    // 判断当前包含数量是否合法
                    if (hasNum > statMap.get(curWord)) {
                        // 子串废了 用while不用for循环的话可以break
                        continue outside;
                    }
                    hasMap.put(curWord, hasNum);
                } else {
                    // 子串废了
                    continue outside;
                }

            }
            // 子串索引加入数组
            result.add(i);

        }


        return result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo", "bar"};
        System.out.println(solution.findSubstring(s1, words1));
    }
}
