package com.zb.leetcode.simple._000;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * @author Zhang Bo
 * @date 2019/11/19 10:25
 */
public class LeetCode_001 {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[]{};
        }
        //暴力法 O(n^2) 时间复杂度
//        for (int i = 0; i < nums.length; i++) {
//            int addTarget = target - nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == addTarget) {
//                    return new int[]{i, j};
//                }
//            }
//        }
        // hash存储目标加数值与下标
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            //判断当前下标值是否在目标值中存在
            if (map.get(nums[i]) != null) {
                return new int[]{map.get(nums[i]), i};
            }
            //不存在,存储当前下标值得目标值
            map.put(target - nums[i], i);
        }
        return new int[]{};
    }
}
