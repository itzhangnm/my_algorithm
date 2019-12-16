package com.zb.study.sort;

/***
 * 冒泡排序
 * @author once
 * @date 2019/11/10 15:38
 *
 */
public class BubbleSortDemo extends BaseSort {

    public static void main(String[] args) {
        BubbleSortDemo bubble = new BubbleSortDemo();
        int[] arr = generateArr(1000);
        printArr(arr);
        long startTime = System.currentTimeMillis();
        int[] newArr = bubble.bubbleSort(arr);
        System.out.println("time:" + (System.currentTimeMillis() - startTime));
        printArr(newArr);
    }


    public int[] bubbleSort(int[] a) {
        if (checkArr(a)) {
            return a;
        }
        //有序边界,有序边界之后的值全部已经有序,不需要比较交换
        int sortBorder = a.length - 1;
        for (int i = 0; i < a.length - 1; i++) {
            //排序标记
            boolean flag = true;
            int lastPosition = 0;
            for (int j = 0; j < sortBorder; j++) {
                if (a[j] > a[j + 1]) {
                    a[j] ^= a[j + 1];
                    a[j + 1] ^= a[j];
                    a[j] ^= a[j + 1];
                    //存在交换,未全部有序
                    flag = false;
                    //记录最后一次交换位置
                    lastPosition = j;
                }
            }
            //最后一次交换位置即为有序边界
            sortBorder = lastPosition;
            //无排序交换证明已经有序
            if (flag) {
                return a;
            }
        }
        return a;
    }
}