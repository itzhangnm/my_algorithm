package com.zb.leetcode.array.simple.a01;

/***
 *
 * @author once
 * @date 2019/12/8 20:15
 *
 */
public class Array_581 {
    /**
     * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     * <p>
     * 你找到的子数组应是最短的，请输出它的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2, 6, 4, 8, 10, 9, 15]
     * 输出: 5
     * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     * 说明 :
     * <p>
     * 输入的数组长度范围在 [1, 10,000]。
     * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int findUnsortedSubarray(int[] nums) {
        int max = nums[0];
        int min = nums[nums.length - 1];
        int l = 0, r = -1;
        for (int i = 1; i < nums.length - 2; i++) {
            if (max > nums[i]) {
                r = i;
            }else{
                max = nums[i];
            }
            int tmp = nums.length - i - 1;
            if (min < nums[tmp]) {
                l = tmp;
            }else{
                min = nums[tmp];
            }
        }
        return r - l + 1;
    }
}
