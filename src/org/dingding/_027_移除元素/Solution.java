package org.dingding._027_移除元素;

import java.util.Arrays;

/**
 * 感觉是双指针？
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length <=0){
            return 0;
        }
        int p1 = 0, p2 = 0;
        int len = nums.length;
        while (p2 < len && p1 < len) {
            while (p2<len && nums[p2] == val) {
                p2++;
            }
            if(p2 < len){
                nums[p1] = nums[p2];
                p1++;
                p2++;
            }


        }

        return p1;

    }

    public static void main(String[] args) {
        int[] ori = {3,2,2,3};
        System.out.println(new Solution().removeElement(ori, 3));
        System.out.println(Arrays.toString(ori));
    }
}
