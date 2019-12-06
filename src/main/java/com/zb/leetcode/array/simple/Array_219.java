package com.zb.leetcode.array.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhang Bo
 * @date 2019/12/6 15:04
 */
public class Array_219 {

    /**
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        Array_219 array_219 = new Array_219();
        System.out.println(array_219.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(array_219.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(array_219.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;

//        for (int i = 0; i < nums.length; i++) {
//            int n = i + k + 1;
//            n = n < nums.length ? n : nums.length;
//            for (int j = i + 1; j < n; j++) {
//                if (nums[i] == nums[j]) {
//                    return true;
//                }
//            }
//        }
//        return false;
    }
}
