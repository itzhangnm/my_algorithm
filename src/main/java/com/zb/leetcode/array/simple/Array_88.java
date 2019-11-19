package com.zb.leetcode.array.simple;

import java.util.Arrays;

/**
 * @author Zhang Bo
 * @date 2019/11/19 14:38
 */
public class Array_88 {

    /**
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * <p>
     * 说明:
     * <p>
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 示例:
     * <p>
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * 输出: [1,2,2,3,5,6]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * [0]
     0
     [1]
     1
     */
    public static void main(String[] args) {
        Array_88 array_88 = new Array_88();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2  = new int[]{2,5,6};
        int n = 3;
        array_88.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //倒序指针初始化
        n--;
        m--;
        //循环判断是否已搬迁完
        while (n >= 0) {
            //目标数组内值已搬迁完或值小于被搬迁值,被搬迁值直接插入
            if (m < 0 || nums2[n] > nums1[m]) {
                nums1[m + n + 1] = nums2[n];
                n--;
            }else{
                //反之,目标数组值自动往后搬迁
                nums1[m + n + 1] = nums1[m];
                m--;
            }
        }
    }
}
