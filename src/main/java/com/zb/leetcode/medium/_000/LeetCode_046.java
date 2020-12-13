package com.zb.leetcode.medium._000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Bo
 * @date 2020/11/11 16:33
 */
public class LeetCode_046 {

    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。

     示例:

     输入: [1,2,3]
     输出:
     [
     [1,2,3],
     [1,3,2],
     [2,1,3],
     [2,3,1],
     [3,1,2],
     [3,2,1]
     ]

     来源：力扣（LeetCode_148）
     链接：https://leetcode-cn.com/problems/permutations
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] flags = new int[nums.length];
        dfs(result, list, nums, flags);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int[] flags) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flags[i] == 1) {
                continue;
            }
            flags[i] = 1;
            list.add(nums[i]);
            dfs(result,list,nums,flags);
            list.remove(list.size() - 1);
            flags[i] = 0;
        }
    }
}
