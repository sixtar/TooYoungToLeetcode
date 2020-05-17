package _015_3_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和(不能重复) 排序暴力法
 * Created by dzj on 2020.5.17.
 */
public class Solution1 {

    /**
     * 主要要处理重复的问题,需要排序,特例太多,不好考虑全
     * 还要考虑全零的情况.目前这种解法leetcode上会报超时,因为有个排序
     * 不使用排序不知道怎么做,动态规划?
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        if (null == nums || nums.length < 3) {
            return r;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 因为已经是从小到大排序,第一个值如果大于零则不可能有匹配的结果
            if (nums[i] > 0) {
                return r;
            }
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> e = Arrays.asList(nums[i], nums[j], nums[k]);
                        r.add(e);
                        // 要跳过重复的,之前想着每次循环前都判断一下,结果没法判断处理
                        // 特别是中间一个值重复的问题,放到循环后就好了
                        while((k+1 < len) && nums[k+1] == nums[k]){
                            k++;
                        }
                    }
                }
                while((j+1 < len) && nums[j+1] == nums[j]){
                    j++;
                }
            }
            while((i+1 < len) && nums[i+1] == nums[i]){
                i++;
            }
        }
        return r;

    }

    public static void main(String[] args) {
        // 特例很多
        // [0,0,0] [-1,0,0,1] [-2,0,1,1,2]
    }
}
