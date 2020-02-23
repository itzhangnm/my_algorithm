package com.zb.leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * @author Zhang Bo
 * @date 2020/2/23 16:36
 */
public class Array_15 {

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * <p>
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        Array_15 array_15 = new Array_15();
        System.out.println(array_15.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //排序后,当前值大于零,则后续所有三数之和必大于0
            if (nums[i] > 0) {
                return result;
            }
            //判断当前值与之前值相同,则重复比较,跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //定位左右指针
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                //计算三数之和,判断值大小移动指针
                int tmp = nums[i] + nums[l] + nums[r];
                if (tmp < 0) {
                    l++;
                } else if (tmp > 0) {
                    r--;
                }else {
                    //添加正确值
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //过滤左右指针重复值
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    //正确后再次移动指针进行计算
                    l++;
                    r--;
                }

            }
        }
        return result;
    }
}
