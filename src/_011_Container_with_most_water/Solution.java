package _011_Container_with_most_water;

/**
 * 双指针求容器的最大容积
 * Created by dzj on 2019.9.21.
 */
public class Solution {

    public int maxArea(int[] height) {
        //入参检查
        int area = 0;
        if (height == null || height.length <= 1) {
            return area;
        }
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            //需要判断左右height的大小,因为如果[left,right]中我们移动了高度较大的一边,
            // 容器高还是取的小的高度小的一边,但是底边减一变短了,容量肯定更小,所以必须移动高度小的一边
            area = Math.max(Math.min(height[left], height[right]) * (right - left), area);
            if (height[left] > height[right]) {
                //移动低的一边
                right--;
            } else if (height[left] < height[right]) {
                left++;
            } else { //相等时应该都往中间移动,否则会多一次操作
                right--;
                left++;
            }
        }

        return area;
    }

    // 这是暴力嵌套循环方法
    public int maxArea000(int[] height) {
        //入参检查
        int len = 0;
        int area = 0;
        if (height == null || (len = height.length) <= 1) {
            return area;
        }
        for (int left = 0; left < len; left++) {
            for (int right = len - 1; right > left; right--) {
                int tmpArea = Math.min(height[right], height[left]) * (right - left);
                area = Math.max(tmpArea, area);
            }
        }

        return area;
    }


    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        //预期值应该是49
        System.out.println(new Solution().maxArea(arr));
    }
}
