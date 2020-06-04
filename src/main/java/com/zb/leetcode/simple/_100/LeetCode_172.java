package com.zb.leetcode.simple._100;

/**
 * 172. 阶乘后的零
 *
 * @author Zhang Bo
 * @date 2020/6/2 11:05
 */
public class LeetCode_172 {

    /**
     * 给定一个整数 n，返回 n! 结果尾数中零的数量。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 3
     * 输出: 0
     * 解释: 3! = 6, 尾数中没有零。
     * 示例 2:
     * <p>
     * 输入: 5
     * 输出: 1
     * 解释: 5! = 120, 尾数中有 1 个零.
     * 说明: 你算法的时间复杂度应为 O(log n) 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_172 leetCode172 = new LeetCode_172();
        System.out.println(leetCode172.trailingZeroes(3));
        System.out.println(leetCode172.trailingZeroes(5));
        System.out.println(leetCode172.trailingZeroes(20));
        System.out.println(leetCode172.trailingZeroes(30));
    }

    public int trailingZeroes(int n) {
        int count = n / 5;
        while (n/ 5 != 0 && n >= 5) {
            n = n / 5;
            count += n / 5;
        }
        return count;
    }
}
