package com.zb.leetcode.medium._000;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * @author Zhang Bo
 * @date 2020/11/13 15:49
 */
public class LeetCode_078 {

    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

     说明：解集不能包含重复的子集。

     示例:

     输入: nums = [1,2,3]
     输出:
     [
     [3],
       [1],
       [2],
       [1,2,3],
       [1,3],
       [2,3],
       [1,2],
       []
     ]

     来源：力扣（LeetCode_148）
     链接：https://leetcode-cn.com/problems/subsets
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backSubsets(nums, result, list, 0);
        result.add(list);
        return result;
    }


    private void backSubsets(int[] nums, List<List<Integer>> result, List<Integer> list, int i) {
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            backSubsets(nums, result, list, j+1);
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
        }
    }
}
