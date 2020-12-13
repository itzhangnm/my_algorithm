package com.zb.leetcode.simple._300;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 350. 两个数组的交集 II
 *
 * @author Zhang Bo
 * @date 2020/6/2 11:05
 */
public class LeetCode_350 {

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * 示例 2:
     * <p>
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     * 说明：
     * <p>
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶:
     * <p>
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_350 leetCode350 = new LeetCode_350();
        System.out.println(JSON.toJSONString(leetCode350.intersect(new int[]{1,2},new int[]{1,1})));
        System.out.println(JSON.toJSONString(leetCode350.intersect(new int[]{1,2,2,1},new int[]{2,2})));
        System.out.println(JSON.toJSONString(leetCode350.intersect(new int[]{4,9,5},new int[]{9,4,9,8,4})));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return this.intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                i++;
                j++;
                count++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }else {
                nums1[i] = -1;
                i++;
            }
        }
        int m = 0;
        int[] r = new int[count];
        for (int k = 0; k < i; k++) {
            if (nums1[k] != -1) {
                r[m++] = nums1[k];
            }
        }
        return r;
    }
}
