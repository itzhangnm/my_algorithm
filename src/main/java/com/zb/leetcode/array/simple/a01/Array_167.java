package com.zb.leetcode.array.simple.a01;

import java.util.Arrays;

/**
 * @author Zhang Bo
 * @date 2019/11/19 16:38
 */
public class Array_167 {

    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * <p>
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     * <p>
     * 说明:
     * <p>
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * 示例:
     * <p>
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        Array_167 array_167 = new Array_167();
        System.out.println(Arrays.toString(array_167.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(array_167.twoSum(new int[]{0, 3, 11, 15}, 3)));
    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) {
            return new int[]{};
        }
        //数组有序
        int i = 0;
        int j = numbers.length - 1;
        //头尾遍历
        while (i < j) {
            int count = numbers[i] + numbers[j];
            //和高于目标值,尾缩小
            if (count > target) {
                j--;
                //和低于目标值,头增加
            } else if (count < target) {
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{};
    }
}
