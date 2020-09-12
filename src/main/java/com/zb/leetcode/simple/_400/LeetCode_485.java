package com.zb.leetcode.simple._400;

/***
 * 485.最大连续1的个数
 * @author once
 * @date 2019/12/8 14:49
 *
 */
public class LeetCode_485 {
    /**
     * 给定一个二进制数组， 计算其中最大连续1的个数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,1,0,1,1,1]
     * 输出: 3
     * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
     * 注意：
     * <p>
     * 输入的数组只包含 0 和1。
     * 输入数组的长度是正整数，且不超过 10,000。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                count++;
            } else {
                max = count > max ? count : max;
                count = 0;
            }
        }
        return count > max ? count : max;
    }
}
