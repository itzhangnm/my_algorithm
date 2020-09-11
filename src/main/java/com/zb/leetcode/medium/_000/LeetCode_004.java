package com.zb.leetcode.medium._000;

import java.util.Arrays;

/***
 * 4. 寻找两个正序数组的中位数
 * @author once
 * @date 2020/9/11 22:37
 *
 */
public class LeetCode_004 {


    public static void main(String[] args) {
        LeetCode_004 leetCode004 = new LeetCode_004();
        System.out.println(leetCode004.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(leetCode004.findMedianSortedArrays(new int[]{1}, new int[]{2,5}));
        System.out.println(leetCode004.findMedianSortedArrays(new int[]{1,6,7,8,9,18}, new int[]{2,4,7,9,16,44}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalNum = nums1.length + nums2.length;
        if (totalNum % 2 == 1) {
            return (double) getNumArrays(nums1, nums2, totalNum / 2 + 1);
        } else {
            return ((double) getNumArrays(nums1, nums2, totalNum / 2 + 1) + (double) getNumArrays(nums1, nums2, totalNum / 2)) / 2;
        }
    }


    private int getNumArrays(int[] numsA, int[] numsB, int num) {
        int indexA = 0;
        int indexB = 0;
        while (true) {
            if (indexA == numsA.length) {
                return numsB[indexB + num - 1];
            }
            if (indexB == numsB.length) {
                return numsA[indexA + num - 1];
            }
            if (num == 1) {
                return Math.min(numsA[indexA], numsB[indexB]);
            }
            int tempIndexA = Math.min(num / 2 - 1 + indexA, numsA.length - 1);
            int tempIndexB = Math.min(num / 2 - 1 + indexB, numsB.length - 1);
            if (numsA[tempIndexA] <= numsB[tempIndexB]) {
                num -= (tempIndexA + 1 - indexA);
                indexA = tempIndexA + 1;
            } else {
                num -= (tempIndexB + 1 - indexB);
                indexB = tempIndexB + 1;
            }
        }
    }
}
