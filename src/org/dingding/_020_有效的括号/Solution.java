package org.dingding._020_有效的括号;


import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        Stack<Character> st = new Stack<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                st.push(c);
                continue;
            }
            if(c == ')' || c == ']' || c == '}'){
                if(st.isEmpty()){
                    return false;
                }
                Character pop = st.pop();
                Character pair = getPair(c);
                if(pair == null || pair != pop){
                    return false;
                }
            }

        }
        // 此处注意还要看栈是不是空的
        if(!st.isEmpty()){
            return false;
        }
        return true;

    }

    private Character getPair(Character left){
        if(left == null){
            return null;
        }
        if(left == ')'){
            return '(';
        }
        if(left == '}'){
            return '{';
        }
        if(left == ']'){
            return '[';
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("{}"));
    }
}
