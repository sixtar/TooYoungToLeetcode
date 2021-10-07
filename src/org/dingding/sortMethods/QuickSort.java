package org.dingding.sortMethods;

/**
 * 快速排序
 * 思路是得到区分点pivot，把比他小的搬到左边，比他大的搬到右边
 * 也是分治的思想，但是是从上到下，先分区
 *
 * @author dzj
 */
public class QuickSort {

    public static void quickSort(int[] arr, int n) {
        quickSortR(arr, 0, n - 1);
    }

    public static void quickSortR(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(arr, p, r);

        // 注意两部分都不包含索引为q的元素
        quickSortR(arr, p, q-1);
        quickSortR(arr, q + 1, r);


    }

    private static int partition(int[] arr, int p, int r) {
        // int pivot = arr[r];
        int pivotIdx = r;
        // 三数取中法，避免最坏情况
       /* int mid = (p+r)/2;
        if(arr[p] > arr[mid] && arr[r] > arr[mid]){
            pivotIdx = mid;
        }else if(arr[p] < arr[r]){
            pivotIdx = p;
        }*/
        int pivot = arr[pivotIdx];

        int i = p;
        // 注意一般情况下j跑的比i快
        for(int j=p;j<r;j++){
            if(arr[j] < pivot){
                // 交换 arr[j]和arr[i]，把比pivot小的都放到前面
                // 换了多少次，则有多少个数比pivot小，则换的次数就是pivot的真实位置
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                i++;
            }

        }
        // 把 pivot的元素放到应该在的位置，当前i位置的元素肯定大于pivot
        int tmp2 = arr[i];
        arr[i] = pivot;
        arr[pivotIdx] = tmp2;


        return i;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] arr = {1,6,2,9,6,2,8,0,65,3,67,8,23,1,553,22,65,77,2,30,23,18,83,86,109,168,11,89,343,1,54,90,17,11};
        BaseSort.printArr(arr);
        quickSort(arr, arr.length);
        BaseSort.printArr(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
