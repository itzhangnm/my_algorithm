package com.zb.leetcode.medium._000;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/***
 * 39. 组合总和
 * @author once
 * @date 2020/11/9 23:06
 *
 */
public class LeetCode_039 {

    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的数字可以无限制重复被选取。
     *
     * 说明：
     *
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1：
     *
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     *   [7],
     *   [2,2,3]
     * ]
     * 示例 2：
     *
     * 输入：candidates = [2,3,5], target = 8,
     * 所求解集为：
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     *  
     *
     * 提示：
     *
     * 1 <= candidates.length <= 30
     * 1 <= candidates[i] <= 200
     * candidate 中的每个元素都是独一无二的。
     * 1 <= target <= 500
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_039 leetCode_039 = new LeetCode_039();
        System.out.println(JSON.toJSONString(leetCode_039.combinationSum(new int[]{2,3,6,7},7)));
        System.out.println(JSON.toJSONString(leetCode_039.combinationSum(new int[]{2,3,5},8)));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSumAll(result,list, candidates, 0,0, target);
        return result;
    }

    private void combinationSumAll(List<List<Integer>> result,List<Integer> list, int[] candidates, int start,int sum, int target) {
        if (start == candidates.length) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        combinationSumAll(result,list,candidates,start+1,sum,target);
        if (sum + candidates[start] <= target) {
            list.add(candidates[start]);
            combinationSumAll(result, list, candidates, start, sum + candidates[start], target);
            list.remove(list.size() - 1);
        }
    }
}
