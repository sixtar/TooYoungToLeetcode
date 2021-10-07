package org.dingding.sortMethods;

/**
 * 插入排序
 * 模拟的是有序集合动态插入元素，寻找元素应该在的位置的思路
 * 逐步实现局部有序
 *
 * @author dzj
 */
public class InsertSort {

    public static void sort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        // 从索引为1的元素往前比较
        for (int i = 1;i<n;i++){
            // 暂存元素
            int val = a[i];
            int j = i - 1;
            for(;j>=0;j--){
                if(a[j]>val){
                    // 往后搬
                    a[j+1] = a[j];
                }else{
                    break;
                }

            }
            if(i != j+1){ // 等于的时候原地未动
                a[j+1] = val;
            }



        }

    }
    public static void main(String[] args) {
        int[] arr = {1,6,2,9,6,2,8, 0};
        BaseSort.printArr(arr);
        sort(arr, arr.length);
        BaseSort.printArr(arr);

    }

}
