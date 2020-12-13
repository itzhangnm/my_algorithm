package com.zb.leetcode.simple._100;

import java.util.Arrays;

/**
 * 169.多数元素
 * @author Zhang Bo
 * @date 2019/11/20 15:58
 */
public class LeetCode_169 {

    /**
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     * <p>
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/majority-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int a = 1 / 2;
        System.out.println(a);
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];

        //排序解法 破坏原数据 排序一半中位数即为众数
//        int i = 0;
//        while (i < nums.length / 2) {
//            boolean flag = true;
//            for (int j = 0; j < nums.length - 1; j++) {
//                if (nums[j] > nums[j + 1]) {
//                    nums[j] ^= nums[j + 1];
//                    nums[j + 1] ^= nums[j];
//                    nums[j] ^= nums[j + 1];
//                    flag = false;
//                }
//            }
//            if (flag) {
//                return nums[nums.length / 2];
//            }
//        }
//        return nums[nums.length / 2];

        //HASH 解法
//        if (nums.length < 3) {
//            return nums[0];
//        }
//        Map<Integer, Integer> map = new HashMap<>();
//        int limit = nums.length / 2;
//        for (int num : nums) {
//            Integer tmp = map.get(num);
//            if (tmp != null) {
//                if (tmp == limit) {
//                    return num;
//                }
//                map.put(num, tmp + 1);
//            } else {
//                map.put(num, 1);
//            }
//        }
//        return 0;
    }
}
