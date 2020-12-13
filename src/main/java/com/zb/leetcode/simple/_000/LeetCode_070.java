package com.zb.leetcode.simple._000;

/**
 * 70. 爬楼梯
 *
 * @author Zhang Bo
 * @date 2020/6/2 11:05
 */
public class LeetCode_070 {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     * <p>
     * 示例 1：
     * <p>
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     * <p>
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/climbing-stairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_070 leetCode070 = new LeetCode_070();
        System.out.println(leetCode070.climbStairs(1));
        System.out.println(leetCode070.climbStairs(2));
        System.out.println(leetCode070.climbStairs(3));
        System.out.println(leetCode070.climbStairs(4));
        System.out.println(leetCode070.climbStairs(5));
        System.out.println(leetCode070.climbStairs(6));
        System.out.println(leetCode070.climbStairs(45));
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int last = 1;
        int result = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = result;
            result = result + last;
            last = tmp;
        }
        return result;
    }
}
