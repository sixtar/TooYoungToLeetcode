package org.dingding.sortMethods;


/**
 * 冒泡排序
 * 思路是从0到n-k元素进行比较，把大的放到后面，先最大，再第二大，再第三大
 * 时间复杂度 O(n^2)
 *
 * @author dzj
 */
public class BubbleSort{

    public static void sort(int[] a, int n){

        if(n <= 1){
            return;
        }
        for(int i=0;i < n;i++){
            boolean sw = false; // 本次是否有交换
            for(int j=0;j<n-i-1;j++){
                if(a[j] > a[j+1]){
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                    sw = true;
                }

            }
            if(!sw){
                break;
            }
        }

    }


    public static void main(String[] args) {
        int[] arr = {1,6,2,9,6,2,8};
        BaseSort.printArr(arr);
        sort(arr, arr.length);
        BaseSort.printArr(arr);

    }
}
