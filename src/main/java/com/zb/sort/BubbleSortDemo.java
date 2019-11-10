package com.zb.sort;

import lombok.extern.slf4j.Slf4j;

/***
 * 冒泡排序
 * @author once
 * @date 2019/11/10 15:38
 *
 */
public class BubbleSortDemo extends BaseSort {

    public static void main(String[] args) {
        BubbleSortDemo bubble = new BubbleSortDemo();
        int[] arr = generateArr(10);
        printArr(arr);
        int[] newArr = bubble.bubbleSort(arr);
        printArr(newArr);
    }


    public int[] bubbleSort(int[] a) {
        if (checkArr(a)) {
            return a;
        }
        for (int i = 0; i < a.length; i++) {
            boolean flag = true;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    a[j] ^= a[j + 1];
                    a[j + 1] ^= a[j];
                    a[j] ^= a[j + 1];
                    flag = false;
                }
            }
            if (flag) {
                return a;
            }
        }
        return a;
    }
}