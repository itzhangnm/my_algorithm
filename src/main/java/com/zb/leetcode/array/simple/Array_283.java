package com.zb.leetcode.array.simple;

/***
 *
 * @author once
 * @date 2019/12/7 11:21
 *
 */
public class Array_283 {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * <p>
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/move-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        Array_283 array_283 = new Array_283();
        int[] nums = new int[]{1};
        array_283.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);

        }
        System.out.println(1 ^ 1 ^ 1);

    }

    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[zeroIndex];
                nums[zeroIndex] = nums[i];
                nums[i] = tmp;
                zeroIndex++;
            }
        }

//        int i = 0;
//        while (i < nums.length) {
//            if (nums[i] == 0) {
//                int j = i + 1;
//                while (j < nums.length) {
//                    if (nums[j] != 0) {
//                        nums[i] = nums[j];
//                        nums[j] = 0;
//                        break;
//                    }
//                    j++;
//                }
//            }
//            i++;
//        }
    }
}
