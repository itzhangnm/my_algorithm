package com.zb.leetcode.medium._500;

import java.util.HashMap;
import java.util.Map;

/***
 * 560. 和为K的子数组
 * @author once
 * @date 2020/12/19 23:52
 *
 */
public class LeetCode_560 {
    /**
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     *
     * 示例 1 :
     *
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     * 说明 :
     *
     * 数组的长度为 [1, 20,000]。
     * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_560 leetCode_560 = new LeetCode_560();
        System.out.println(leetCode_560.subarraySum(new int[]{-1,-1,1},0));
    }

    public int subarraySum(int[] nums, int k) {
        int pre = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
