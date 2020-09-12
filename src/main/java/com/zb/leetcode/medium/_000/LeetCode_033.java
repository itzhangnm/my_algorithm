package com.zb.leetcode.medium._000;

/**
 * 33. 搜索旋转排序数组
 *
 * @author Zhang Bo
 * @date 2020/2/23 17:31
 */
public class LeetCode_033 {
    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * <p>
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * <p>
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * <p>
     * 你可以假设数组中不存在重复的元素。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * <p>
     * 示例 2:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_033 leetCode033 = new LeetCode_033();
        System.out.println(leetCode033.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(leetCode033.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    public int search(int[] nums, int target) {
        if (nums.length < 1) {
            return -1;
        }
        //定位目标值处于左右哪个区间
        boolean isLeft = nums[0] <= target;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] == target) {
                //目标值返回
                return m;
            } else {
                if (nums[l] < nums[r]) {
                    // l r完全处于一个有序区间
                    if (nums[m] < target) {
                        l = m + 1;
                    }else {
                        r = m - 1;
                    }
                } else {
                    //l  r 不处于一个有序区间
                    if (isLeft) {
                        //左区间,只有在当前值小于目标值且当前值大于r值时,l才移动
                        if (nums[m] < target && nums[m] > nums[r]) {
                            l = m + 1;
                        } else {
                            r = m - 1;
                        }
                    } else {
                        //右区间,只有在当前值大于目标值且当前值小于l值时,r才移动
                        if (nums[m] > target && nums[m] < nums[l]) {
                            r = m - 1;
                        } else {
                            l = m + 1;
                        }
                    }
                }

            }
        }
        return -1;
    }
}
