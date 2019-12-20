package com.zb.study.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Zhang Bo
 * @date 2019/12/19 18:25
 */
public class BucketSortDemo extends BaseSort {

    public static void main(String[] args) {
        BucketSortDemo bucket = new BucketSortDemo();
        int[] arr = generateArr(1000000);
//        printArr(arr);
        long startTime = System.currentTimeMillis();
        int[] newArr = bucket.bucketSort(arr,50);
//        printArr(newArr);
        System.out.println("time:" + (System.currentTimeMillis() - startTime));
    }

    public int[] bucketSort(int[] nums,int n) {
        List<List<Integer>> lists = Stream.generate(ArrayList<Integer>::new).limit(n).collect(Collectors.toList());
        for (int i = 0; i < nums.length; i++) {
            lists.get(getBucket(nums[i])).add(nums[i]);
        }
        QuickSortDemo quickSort = new QuickSortDemo();

        int count = 0;
        for (List<Integer> list : lists) {
            int start = count;
            for (Integer integer : list) {
                nums[count++] = integer;
            }
            quickSort.quickSort(nums, start, count - 1);
        }
        return nums;
    }

    private int getBucket(int num) {
        if (num % 2 == 1) {
            num--;
        }
        return num / 2;
    }

}
