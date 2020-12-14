package com.zb.leetcode.medium._100;

/***
 * 152. 乘积最大子数组
 * @author once
 * @date 2020/12/14 22:30
 *
 */
public class LeetCode_152 {

    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     * <p>
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_152 leetCode_152 = new LeetCode_152();
        System.out.println(leetCode_152.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(leetCode_152.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(leetCode_152.maxProduct(new int[]{1, 2, -1, 3, -4}));
    }

    public int maxProduct(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        int len = nums.length + 1;
//        int[] dp = new int[len];
//        for (int i = 0; i  < len; i++) {
//            dp[i] = 1;
//        }
//        for (int i = 1; i < len; i++) {
//            for (int j = 0; j < len - 1; j++) {
//                dp[j] = nums[j] * dp[j + 1];
//                max = Math.max(max, dp[j]);
//            }
//        }
//        return max;
        int res, min, max;
        res = nums[0];
        min = nums[0];
        max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tMin = min;
            int tMax = max;
            min = Math.min(nums[i] * tMin, Math.min(nums[i], nums[i] * tMax));
            max = Math.max(nums[i] * tMax, Math.max(nums[i], nums[i] * tMin));
            res = Math.max(max, res);
        }
        return res;
    }
}
