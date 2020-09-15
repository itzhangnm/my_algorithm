package com.zb.leetcode.medium._200;

/**
 * 215. 数组中的第K个最大元素
 *
 * @author Zhang Bo
 * @date 2020/9/15 15:19
 */
public class LeetCode_215 {

    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     * <p>
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     * 说明:
     * <p>
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_215 leetCode215 = new LeetCode_215();
        System.out.println(leetCode215.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(leetCode215.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        for (int i = n / 2; i >= 0; i--) {
            heapfily(nums, n, i);
        }
        for (int i = n - 1; i > nums.length - k; i--) {
            swap(nums, 0, i);
            n--;
            heapfily(nums, n, 0);
        }
        return nums[0];
    }

    private void heapfily(int[] nums, int n, int i) {
        while (true) {
            int max = i;
            if (i * 2 + 1 < n && nums[i * 2 + 1] > nums[max]) {
                max = i * 2 + 1;
            }
            if (i * 2 + 2 < n && nums[i * 2 + 2] > nums[max]) {
                max = i * 2 + 2;
            }
            if (i == max) {
                break;
            }
            swap(nums, i, max);
            i = max;
        }
    }

    private void swap(int[] nums, int i, int max) {
        nums[i] ^= nums[max];
        nums[max] ^= nums[i];
        nums[i] ^= nums[max];
    }
}
