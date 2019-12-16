package com.zb.study.sort;

/**
 * @author Zhang Bo
 * @date 2019/12/16 17:37
 */
public class SelectSortDemo extends BaseSort {

    public static void main(String[] args) {
        SelectSortDemo select = new SelectSortDemo();
        int[] arr = generateArr(10);
        printArr(arr);
        long startTime = System.currentTimeMillis();
        int[] newArr = select.selectSort(arr);
        System.out.println("time:" + (System.currentTimeMillis() - startTime));
        printArr(newArr);
    }

    private int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                arr[i] ^= arr[min];
                arr[min] ^= arr[i];
                arr[i] ^= arr[min];
            }
        }
        return arr;
    }
}
