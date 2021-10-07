package org.dingding._数组全排列打印;

/**
 * 思路是逐渐确定最后一位是哪个数，然后再确定剩下的前n-1个子列的顺序
 *
 * 在想如果正向去做，然后拼接字符串，然后用string的contains方法进行剪枝应该也行
 */
public class Solution {

    public static int  count = 0;

    public void printPermutations(int[] data, int n, int k) {

        // 递归终止条件是到倒数最后一个，此时位置都换好了，可以把换好的data数组打印出来
        if (k == 1) {
            for (int ii = 0; ii < n; ii++) {
                System.out.print(data[ii] + " ");
            }
            System.out.println();
            count++;


        }
        // 这个for循环会走很多次,所以时间复杂度很高
        for (int i = 0; i < k; i++) {
            // 把第i个元素换到k-1的索引位置
            int tmp = data[k - 1];
            data[k - 1] = data[i];
            data[i] = tmp;

            // 递归调用，处理剩下的前k-1个数
            printPermutations(data, n, k - 1);

            // 再换回来好处理下一次循环
            tmp = data[k - 1];
            data[k - 1] = data[i];
            data[i] = tmp;
        }


    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        int len = arr.length;
        new Solution().printPermutations(arr, len, len);
        System.out.println(count);
    }
}
