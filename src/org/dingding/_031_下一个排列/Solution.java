package org.dingding._031_下一个排列;

/**
 * 参照题解 https://leetcode.cn/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
 * 主要还是思路没理清，ErrorSolution中想了两个都部分对，但关键处不对
 * 另外就是发现自己翻转数组和冒泡的边界条件不是十分明确
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        new Solution().nextPermutation(arr);
        int[] arr1 = {1, 1, 5};
        new Solution().nextPermutation(arr1);
        int[] arr2 = {1, 3, 2}; // 2,1,3
        new Solution().nextPermutation(arr2);
        // 有相同值的案例
        int[] arr3 = {4, 2, 0, 2, 3, 2, 0}; // [4,2,0,3,0,2,2]
        new Solution().nextPermutation(arr3);
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            System.out.println(arrayToStr(nums));
            return;
        }
        int len = nums.length;
        // 从后往前找第一对后边比前边大的
        for (int o = len - 1; o > 0; o--) {
            // 找到第一组右边比左边高的
            if (nums[o] > nums[o - 1]) {
                // 从索引end到o找到第一个o-1处数大的（比nums[o-1]大的最小数）交换，此时o到end依然是降序的
                boolean switchFlag = false;
                for (int searchIdx = len - 1; searchIdx >= o; searchIdx--) {
                    if (nums[searchIdx] > nums[o - 1]) {
                        int tmp = nums[searchIdx];
                        nums[searchIdx] = nums[o - 1];
                        nums[o - 1] = tmp;
                        switchFlag = true;
                        break;
                    }
                }
                // 交换过，逆序o到end
                if (switchFlag) {
                    int mid = (len - o) / 2;
                    for (int idx = 0; idx < mid; idx++) {
                        int tmp = nums[o + idx];
                        nums[o + idx] = nums[len - 1 - idx];
                        nums[len - 1 - idx] = tmp;
                    }
                    System.out.println(arrayToStr(nums));
                    return;
                } else {
                    // 因为o到后面是降序的，应该不存在没交换的情况
                }
            }


        }
        // 到外层最低也没有交换输出，则翻转数组
        int mid = len / 2;
        for (int idx = 0; idx <= mid - 1; idx++) {
            int tmp = nums[idx];
            nums[idx] = nums[len - 1 - idx];
            nums[len - 1 - idx] = tmp;
        }
        System.out.println(arrayToStr(nums));


    }

    private String arrayToStr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (arr == null) {
            return null;
        }
        if (arr.length == 0) {
            sb.append("]");
            return sb.toString();
        }
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
