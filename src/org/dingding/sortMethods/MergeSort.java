package org.dingding.sortMethods;

/**
 * 归并排序
 * 分治的思想
 * 缺点，不是原地排序算法。需要申请很多空间
 *
 * @author dzj
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int n) {
        mergeSortR(arr, 0, n-1);
    }


    // 递归
    public static void mergeSortR(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }

        int middle = (p+r) / 2;
        mergeSortR(arr, p, middle);
        mergeSortR(arr, middle + 1, r);

        merge(arr, p, middle, r);


    }

    private static void merge(int[] arr, int p, int middle, int r) {
        int[] tmp = new int[r - p + 1];
        // i,j是两半数组的游标，k是新数组的游标
        int i = p, j = middle + 1, k = 0;
        while (i <= middle && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        // 看看那个还有剩余
        int start = i, end = middle;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            tmp[k++] = arr[start++];
        }
        for (int ii = 0; ii < r - p + 1; ii++) {
            arr[ii+p] = tmp[ii];
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,6,2,9,6,2,8, 0};
        BaseSort.printArr(arr);
        mergeSort(arr, arr.length);
        BaseSort.printArr(arr);

    }
}
