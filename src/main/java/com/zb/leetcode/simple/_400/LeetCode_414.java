package com.zb.leetcode.simple._400;

/***
 * 414.第三大的数
 * @author once
 * @date 2019/12/8 10:52
 *
 */
public class LeetCode_414 {
    /**
     * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3, 2, 1]
     * <p>
     * 输出: 1
     * <p>
     * 解释: 第三大的数是 1.
     * 示例 2:
     * <p>
     * 输入: [1, 2]
     * <p>
     * 输出: 2
     * <p>
     * 解释: 第三大的数不存在, 所以返回最大的数 2 .
     * 示例 3:
     * <p>
     * 输入: [2, 2, 3, 1]
     * <p>
     * 输出: 1
     * <p>
     * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
     * 存在两个值为2的数，它们都排第二。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/third-maximum-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_414 leetCode_414 = new LeetCode_414();
        System.out.println(leetCode_414.thirdMax(new int[]{3, 2, 1}));
        System.out.println(leetCode_414.thirdMax(new int[]{1, 2}));
        System.out.println(leetCode_414.thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println(leetCode_414.thirdMax(new int[]{1,2,2,5,3,5}));
        System.out.println(leetCode_414.thirdMax(new int[]{1,-2147483648,2}));

    }

    public int thirdMax(int[] nums) {
        int count = 1;
        int maxInt = nums[0];
        int lastInt = Integer.MIN_VALUE;
        int thirdInt = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= maxInt) {
                if (nums[i] != maxInt) {
                    thirdInt = lastInt;
                    lastInt = maxInt;
                    maxInt = nums[i];
                    count++;
                }
            } else if (nums[i] >= lastInt) {
                if (nums[i] != lastInt || lastInt == Integer.MIN_VALUE) {
                    thirdInt = lastInt;
                    lastInt = nums[i];
                    count++;
                }
            } else if (nums[i] >= thirdInt) {
                if (nums[i] != thirdInt || thirdInt == Integer.MIN_VALUE) {
                    thirdInt = nums[i];
                    count++;
                }
            }
        }
        return count < 3 ? maxInt : thirdInt;
    }


}
