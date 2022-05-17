package org.dingding._031_下一个排列;

/**
 * 本来想着双指针啥的。。看来是个错误的思路。。。
 * 后面发现部分思路是正确的，就是找到交换的数不对
 * 递归应该也是走不通的，因为会互相影响
 */
public class ErrorSolution {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        new ErrorSolution().nextPermutation(arr);
        int[] arr1 = {1, 1, 5};
        new ErrorSolution().nextPermutation(arr1);
        int[] arr2 = {1, 3, 2}; // 2,1,3
        new ErrorSolution().nextPermutation(arr2);
        // 这个案例不通过。。
        int[] arr3 = {4, 2, 0, 2, 3, 2, 0}; // [4,2,0,3,0,2,2]
        new ErrorSolution().nextPermutation(arr3);
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            System.out.println(arrayToStr(nums));
            return;
        }
        int len = nums.length;
        // 应该是双指针 [... nums[i] ... nums[o] ...]
        // 外面指针从len-1 到 1，内指针从 len-1 -1到0
        for (int o = len - 1; o > 0; o--) { // 外

            for (int i = o - 1; i >= 0; i--) { // 内
                // 判断nums[o]和nums[i]的大小关系
                // 边界条件是no < ni 且 ？
                if (nums[o] > nums[i]) {
                    int tmp = nums[o];
                    nums[o] = nums[i];
                    nums[i] = tmp;
                    // 从nums[i+1]往后再从小到大排个序？
                    // 普通的冒泡排序，排序次数
                    for (int count = 0; count < len - (i + 1) - 1; count++) {
                        for (int jj = i + 1; jj < len - 1 - count; jj++) {
                            if (nums[jj] > nums[jj + 1]) {
                                int tmpSort = nums[jj];
                                nums[jj] = nums[jj + 1];
                                nums[jj + 1] = tmpSort;
                            }
                        }
                    }

                    System.out.println(arrayToStr(nums));
                    return;
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


//        // 思路是从高往低比对，如果高位大于低位，就交换返回，否则往低位看，到最低也没有就把数组翻转
//        int c = len - 1;
//        while(c >= 1){
//            if(nums[c] > nums[c-1]){
//                int tmp = nums[c];
//                nums[c] = nums[c-1];
//                nums[c-1] = tmp;
//                System.out.println(arrayToStr(nums));
//                return;
//            }
//            c--;
//        }
//        // 到最低也没有交换输出，则翻转数组
//        int mid = len/2;
//        for(int idx= 0; idx <= mid - 1; idx++){
//            int tmp = nums[idx];
//            nums[idx] = nums[len - 1 - idx];
//            nums[len - 1 - idx] = tmp;
//        }
//        System.out.println(arrayToStr(nums));
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
