package com.zb.leetcode.medium._000;

import com.alibaba.fastjson.JSON;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * @author Zhang Bo
 * @date 2020/2/23 18:52
 */
public class LeetCode_034 {
    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 如果数组中不存在目标值，返回 [-1, -1]。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * <p>
     * 示例 2:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_034 leetCode034 = new LeetCode_034();
        System.out.println(JSON.toJSONString(leetCode034.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(JSON.toJSONString(leetCode034.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(JSON.toJSONString(leetCode034.searchRange(new int[]{2,2}, 2)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length < 1) {
            return result;
        }
        //二分查找,先找第一个
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                if (m == 0 || nums[m - 1] < target) {
                    result[0] = m;
                    break;
                }
                r = m - 1;
            }
        }
        //判断第一个找到
        if (result[0] == -1) {
            return result;
        }
        //二分查找找最后一个
        l = result[0];
        r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                if (m == nums.length - 1 || nums[m + 1] > target) {
                    result[1] = m;
                    return result;
                }
                l = m + 1;
            }
        }
        return result;
    }
}
