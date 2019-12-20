package com.zb.study.sort;

/**
 * @author Zhang Bo
 * @date 2019/12/16 19:41
 */
public class QuickSortDemo extends BaseSort {
    public static void main(String[] args) {
        QuickSortDemo quick = new QuickSortDemo();
        int[] arr = generateArr(1000000);
//        printArr(arr);
        long startTime = System.currentTimeMillis();
        int[] newArr = quick.quickSort(arr);
        System.out.println("time:" + (System.currentTimeMillis() - startTime));
//        printArr(newArr);
    }

    public int[] quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = quick(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private int quick(int[] arr, int l, int r) {
        int j = l;
        for (int i = l; i < r; i++) {
            if (arr[i] < arr[r]) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                j++;
            }
        }
        int tmp = arr[r];
        arr[r] = arr[j];
        arr[j] = tmp;
        return j;
    }


}
