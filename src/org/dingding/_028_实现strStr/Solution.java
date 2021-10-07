package org.dingding._028_实现strStr;

/**
 * 暴力匹配方式，复杂的需要考虑kmp算法，这里先不学这个算法的具体实现
 */
public class Solution {

    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }
        int strLen = haystack.length();
        int tarLen = needle.length();

        if(strLen < tarLen){
            return -1;
        }
        if("".equals(needle)){
            return 0;
        }

        for(int p1=0;p1<=strLen-tarLen;p1++){

            int count = 0;
            int p2 = p1;
            while(p2 < strLen && count < tarLen){
                if(haystack.charAt(p2) == needle.charAt(count)){
                    p2++;
                    count++;
                }else{
                    break;
                }
            }
            if(count == tarLen){
                return p1;
            }

        }

        return -1;

    }


    public static void main(String[] args) {
        System.out.println(new Solution().strStr("hello", "ll"));
    }

}
