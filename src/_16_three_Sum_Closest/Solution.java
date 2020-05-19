package _16_three_Sum_Closest;

import java.util.Arrays;

/**
 * 求三个数和目标值插值最小的和
 * Created by dzj on 2020.5.19.
 */
public class Solution {

    // 典型思路是排序加双指针，双指针必须在排序好的情况下才能使用。
// 双指针时间复杂度是O(n^2)，普通暴力法三重循环时间复杂度是O(n^3)
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        // 需要排序
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[nums.length - 1];
        ;
        for (int i = 0; i < nums.length; i++) {
            int a = i + 1;
            int b = nums.length - 1;
            if (a >= nums.length) {
                return sum;
            }
            while (a < b) {
                int sum0 = nums[i] + nums[a] + nums[b];
                int deltaOri = abs(sum - target);
                int delta0 = abs(sum0 - target);
                // 如果结果更接近则更新sum
                if (delta0 == 0) {
                    return sum0;
                }
                if (delta0 < deltaOri) {
                    sum = sum0;
                }
                // 根据和和目标值的关系确定移动哪一边的指针
                if (sum0 > target) {
                    b--;
                } else {
                    a++;
                }

            }


        }
        return sum;


    }

    public static int abs(int ori) {
        if (ori > 0) {
            return ori;
        } else {
            return -ori;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }

}
