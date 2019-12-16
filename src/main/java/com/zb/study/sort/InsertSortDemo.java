package com.zb.study.sort;

/**
 * @author Zhang Bo
 * @date 2019/12/16 17:36
 */
public class InsertSortDemo extends BaseSort {

    public static void main(String[] args) {
        InsertSortDemo insert = new InsertSortDemo();
        int[] arr = generateArr(10000);
//        printArr(arr);
        long startTime = System.currentTimeMillis();
        int[] newArr = insert.insertSort(arr);
        System.out.println("time:" + (System.currentTimeMillis() - startTime));
//        printArr(newArr);
    }

    public int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int tmp = arr[i];
            while (j >= 0) {
                if (arr[j] <= tmp) {
                    break;
                }
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }
}
