package _1_Two_sum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by dzj on 2019.9.9.
 */
public class TwoSum1 {

    /**
     * 思路是用一个map存放 值:索引 格式的数据
     * 主要是遍历时不能回头,每个数据只访问一次，区别于原始简单粗暴方法:两个指针去遍历(时间复杂度O(n^2))
     * 这里的时间复杂度是O(n),空间复杂度是O(n)
     *
     * @param nums 入参数组
     * @param target 要查找的和
     * @return 返回两个索引位置的数组
     */
    private static int[] twoSum(int[] nums, int target) {

        //定义默认返回值
        int[] res = new int[2];
        //入参校验
        if (null == nums || nums.length <= 1) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= nums.length; i++) {
            int aNum = nums[i];
            //得到差值
            int deduce = target - aNum;
            //从map里取插值
            Integer getValIdx = map.get(deduce);
            //不为空说明能找到匹配的值
            if (getValIdx != null) {
                res[0] = i;
                res[1] = getValIdx;
                return res;
            } else {//否则将当前值和索引丢到map里
                map.put(aNum, i);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] testArr = {1, 2, 9, 7, 5};
        int target = 9;
        int[] ints = twoSum(testArr, target);
        //期望结果应该是2和7的索引 1和3
        System.out.println(Arrays.toString(ints));
    }
}
