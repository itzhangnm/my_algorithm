package com.zb.study.sort;

/**
 * @author Zhang Bo
 * @date 2019/12/16 18:11
 */
public class MergeSortDemo extends BaseSort {

    public static void main(String[] args) {
        MergeSortDemo merge = new MergeSortDemo();
        int[] arr = generateArr(10000);
//        printArr(arr);
        long startTime = System.currentTimeMillis();
        int[] newArr = merge.mergeSort(arr);
        System.out.println("time:" + (System.currentTimeMillis() - startTime));
//        printArr(newArr);
    }

    private int[] mergeSort(int[] arr) {
        merge(arr, 0, arr.length - 1);
        return arr;
    }

    private void merge(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = (l + r) / 2;
        merge(arr, l, p);
        merge(arr, p + 1, r);
        merge(arr, l, p, r);
    }

    private void merge(int[] arr, int l, int p, int r) {
        int[] tmp = new int[r - l + 1];
        int i = l;
        int j = p + 1;
        int k = 0;
        while (i <= p && j <= r) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        //判断左右2个谁遍历完了
        if (i > p) {
            i = j;
            p = r;
        }
        //剩余的
        while (i <= p) {
            tmp[k++] = arr[i++];
        }
        //排序好的重新赋值
        for (int m = 0; m < tmp.length; m++) {
            arr[l + m] = tmp[m];
        }
    }
}
