package org.dingding._026_删除有序数组中的重复项;

import java.util.Arrays;

public class Solution {

    public int removeDuplicates(int[] nums) {

        // 感觉有点像双指针？p2为新数组不重复元素存储的位置
        int len = nums.length;
        if(len <= 1){
            return len;
        }
        int p2 = 0;
        int last = nums[0];
        for (int p1 = 1; p1 < len; p1++) {
            if (nums[p1] != last) {
                p2++;
                nums[p2] = nums[p1];
                last = nums[p2];
            }



        }
        return p2+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = new Solution().removeDuplicates(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }


}
