package com.zb.leetcode.medium._400;

import java.util.Stack;

/**
 * 456.132模式
 * @author Zhang Bo
 * @date 2019/11/18 18:23
 */
public class LeetCode_456 {

    /**
     * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
     * <p>
     * 注意：n 的值小于15000。
     * <p>
     * 示例1:
     * <p>
     * 输入: [1, 2, 3, 4]
     * <p>
     * 输出: False
     * <p>
     * 解释: 序列中不存在132模式的子序列。
     * 示例 2:
     * <p>
     * 输入: [3, 1, 4, 2]
     * <p>
     * 输出: True
     * <p>
     * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
     * 示例 3:
     * <p>
     * 输入: [-1, 3, 2, 0]
     * <p>
     * 输出: True
     * <p>
     * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/132-pattern
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_456 leetCode_456 = new LeetCode_456();
        System.out.println(leetCode_456.find132pattern(new int[] {1, 2, 3, 4}));
        System.out.println(leetCode_456.find132pattern(new int[] {3, 1, 4, 2}));
        System.out.println(leetCode_456.find132pattern(new int[] {-1, 3, 2, 0}));
        System.out.println(leetCode_456.find132pattern(new int[] {1,0,1,-4,-3}));
        System.out.println(leetCode_456.find132pattern(new int[] {-1,2,1,-2,10}));
    }
    public boolean find132pattern(int[] nums) {//
        if (nums.length < 3) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        //记录最接近最大值的次大值
        int nextMax = Integer.MIN_VALUE;
        //倒序
        stack.push(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            //满足左侧当前值小于次大值,即满足条件
            if (nums[i] < nextMax) {
                return true;
            }else {
                //当前遍历值大于栈顶值,更新次大值为当前栈顶元素
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    nextMax = stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        return false;

    }
}
