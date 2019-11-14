package com.zb.leetcode.stack.simple;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Zhang Bo
 * @date 2019/11/14 16:15
 */
public class Stack_496 {

    /*
    给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。

    nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。

    示例 1:

    输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
    输出: [-1,3,-1]
    解释:
    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
    示例 2:

    输入: nums1 = [2,4], nums2 = [1,2,3,4].
    输出: [3,-1]
    解释:
                对于num1中的数字2，第二个数组中的下一个较大数字是3。
    对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
    注意:

    nums1和nums2中所有元素是唯一的。
    nums1和nums2 的数组大小都不超过1000。
    */

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        Stack_496 stack_496 = new Stack_496();
        int[] result = stack_496.nextGreaterElement02(nums1, nums2);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] nextGreaterElement01(int[] nums1, int[] nums2) {
        //2个栈循环pop push
        Stack<Integer> total = new Stack<>();
        Stack<Integer> reverseTotal = new Stack<>();
        for (int i = nums2.length - 1; i > -1; i--) {
            //初始化
            total.push(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = -1;
            while (!total.isEmpty()) {
                //原栈弹出,定位到子集合数的位置
                reverseTotal.push(total.pop());
                if (reverseTotal.peek() == nums1[i]) {
                    break;
                }
            }

            while (!total.isEmpty()) {
                //继续pop,找到第一个大于的值
                reverseTotal.push(total.pop());
                if (reverseTotal.peek() > nums1[i]) {
                    result[i] = reverseTotal.peek();
                    break;
                }
            }
            //重新初始化
            while (!reverseTotal.isEmpty()) {
                total.push(reverseTotal.pop());
            }

        }
        return result;
    }

    public int[] nextGreaterElement02(int[] nums1, int[] nums2) {
        //单栈 hash存储
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            //遍历大数组 循环判断已经存在栈里面的值小于当前值 若小于,则栈内所有值都定位到了第一个最大值
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                //循环出栈,hash记录
                map.put(stack.pop(), nums2[i]);
            }
            //当前值始终会push
            stack.push(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            //取自己值对应的最大值
            result[i] = map.get(nums1[i]) == null ? -1 : map.get(nums1[i]);
        }
        return result;
    }

}
