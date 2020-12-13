package com.zb.leetcode.medium._000;

import com.alibaba.fastjson.JSON;

/***
 * 31. 下一个排列
 * @author once
 * @date 2020/11/8 15:21
 *
 */
public class LeetCode_031 {
    /**
     * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     * <p>
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * <p>
     * 必须原地修改，只允许使用额外常数空间。
     * <p>
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/next-permutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_031 leetCode_031 = new LeetCode_031();
        int[] nums = new int[]{1, 2, 3};
        leetCode_031.nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));

        nums = new int[]{3, 2, 1};
        leetCode_031.nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));


        nums = new int[]{2,3,1};
        leetCode_031.nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));

        nums = new int[]{1, 1, 5};
        leetCode_031.nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));

        nums = new int[]{2, 1, 3, 4};
        leetCode_031.nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));


        nums = new int[]{1,3,2};
        leetCode_031.nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));


        nums = new int[]{1,2,5,4,3};
        leetCode_031.nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));

        nums = new int[]{2,3,1,3,3};
        leetCode_031.nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));
    }

    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            //从右找到第一个大于前置位的index
            if (nums[i] > nums[i - 1]) {
                int minIndex = i;
                int j = nums.length - 1;
                //从index处往后找最小大于前置位的数
                while (j > i) {
                    if (nums[j] > nums[i - 1]) {
                        minIndex = j;
                        break;
                    }
                    j--;
                }
                nums[minIndex] ^= nums[i - 1];
                nums[i - 1] ^= nums[minIndex];
                nums[minIndex] ^= nums[i - 1];
                j = nums.length - 1;
                //index后面为一个降序列,改成升序列,即为最小
                while (i < j) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    i++;
                    j--;
                }
                return;
            }
        }
        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = nums[i];
            nums[i] = tmp;
        }
    }

}
