package com.zb.leetcode.sword;

/***
 * 剑指 Offer 03. 数组中重复的数字
 * @author once
 * @date 2020/11/21 23:39
 *
 */
public class Sword_03 {

    /**
     * 找出数组中重复的数字。
     * <p>
     * <p>
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     *  
     * <p>
     * 限制：
     * <p>
     * 2 <= n <= 100000
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        Sword_03 sword_03 = new Sword_03();
        System.out.println(sword_03.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(sword_03.findRepeatNumber(new int[]{0, 1, 2, 0, 4, 5, 6, 7, 8, 9}));
        System.out.println(sword_03.findRepeatNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 15}));
    }

    public int findRepeatNumber(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            while (nums[i] != i) {
//                if (nums[i] == nums[nums[i]]) {
//                    return nums[i];
//                }
//                int j = nums[i];
//                int temp = nums[j];
//                nums[j] = nums[i];
//                nums[i] = temp;
//            }
//        }
//        return -1;

        //不改变原数组
        int start = 1;
        int end = nums.length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = count(nums, start, middle);
            if (start == end) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return 0;
    }

    private int count(int[] nums, int start, int end) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= start && nums[i] <= end) {
                count++;
            }
        }
        return count;
    }


}
