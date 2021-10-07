package org.dingding.sortMethods;

/**
 * @author dzj
 */
public interface BaseSort {

    static void printArr(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int ele : arr){
            sb.append(ele).append(" ");
        }
        System.out.println(sb);
    }

}
