package com.zb.leetcode.simple._000;

/**
 * 53 最大子序和
 * @author Zhang Bo
 * @date 2019/11/19 11:35
 */
public class LeetCode_053 {
    /**
     *
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

     示例:

     输入: [-2,1,-3,4,-1,2,1,-5,4],
     输出: 6
     解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     进阶:

     如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

     来源：力扣（LeetCode_148）
     链接：https://leetcode-cn.com/problems/maximum-subarray
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    public static void main(String[] args) {
        LeetCode_053 leetCode053 = new LeetCode_053();
        System.out.println(leetCode053.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int sum = nums[0];
        int tmp = sum;
        for (int i = 1; i < nums.length; i++) {
            //从正数开始计算
            if (tmp >= 0) {
                //累加结果为正
                tmp += nums[i];
            }else {
                //负数,取当前值即可,前面累加最大值已有记录
                tmp = nums[i];
            }
            //每次累加判断最大
            sum = tmp > sum ? tmp : sum;
        }
        return sum;
    }
}
