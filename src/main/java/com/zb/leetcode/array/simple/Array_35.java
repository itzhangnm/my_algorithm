package com.zb.leetcode.array.simple;

/**
 * @author Zhang Bo
 * @date 2019/11/19 11:16
 */
public class Array_35 {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 你可以假设数组中无重复元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     * <p>
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 示例 4:
     * <p>
     * 输入: [1,3,5,6], 0
     * 输出: 0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-insert-position
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        Array_35 array_35 = new Array_35();
//        System.out.println(array_35.searchInsert(new int[]{1,3,5,6},5));
//        System.out.println(array_35.searchInsert(new int[]{1,3,5,6},2));
//        System.out.println(array_35.searchInsert(new int[]{1,3,5,6},7));
//        System.out.println(array_35.searchInsert(new int[]{1,3,5,6},0));
        System.out.println(array_35.searchInsert(new int[]{1},0));
    }
    public int searchInsert(int[] nums, int target) {
        if (nums.length < 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            //顺序遍历,存在大于等于,则当前位置为插入位置
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
