package org.dingding._018_four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dzj
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4){
            return result;
        }
        // 先排序
        Arrays.sort(nums);

        // 循环需要跳过重复的数。。。
        for(int i = 0;i < nums.length;i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i+1;j < nums.length;j++){
                if(j > i+1 && nums[j] == nums[j - 1]){
                    continue;
                }
                // 内部使用双指针减少一层循环，否则复杂度是n^4
                int low = j + 1;
                int high = nums.length - 1;
                while(low < high){
                    // 双指针部分也需要跳过重复的
                    if(low > j + 1 && nums[low] == nums[low-1]){
                        low++;
                        continue;
                    }
                    if((high < nums.length-1) && nums[high] == nums[high+1]){
                        high--;
                        continue;
                    }

                    // 指针向中间移动
                    if(nums[i] + nums[j] + nums[low] + nums[high] < target){
                        low++;
                    } else if(nums[i] + nums[j] + nums[low] + nums[high] > target){
                        high--;
                    } else { // 相等
                        System.out.println(" ["+nums[i]+","+nums[j]+","+nums[low]+","+nums[high]+"] ");
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[low]);
                        l.add(nums[high]);
                        result.add(l);

                        low++; // ??
                        high--;
                    }

                }



            }


        }



        return result;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        // int[] nums = {1,0,-1,0,-2,2};
        int[] nums = {-2,-1,-1,1,1,2,2};
        int target = 0;
        s.fourSum(nums, target);


    }

}
