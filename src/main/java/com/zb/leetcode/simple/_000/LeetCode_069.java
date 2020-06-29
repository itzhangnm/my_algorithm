package com.zb.leetcode.simple._000;

/**
 * 69. x 的平方根
 *
 * @author Zhang Bo
 * @date 2020/6/2 11:05
 */
public class LeetCode_069 {

    /**
     * 实现 int sqrt(int x) 函数。
     * <p>
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * <p>
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 4
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     *      由于返回类型是整数，小数部分将被舍去。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sqrtx
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_069 leetCode069 = new LeetCode_069();
        System.out.println(leetCode069.mySqrt(10));
        System.out.println(leetCode069.mySqrt(4));
        System.out.println(leetCode069.mySqrt(5));
        System.out.println(leetCode069.mySqrt(8));
        System.out.println(leetCode069.mySqrt(25));
        System.out.println(leetCode069.mySqrt(25));
        System.out.println(leetCode069.mySqrt(2147395599));
        System.out.println(46339 * 46339);
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 0, right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            long num = (long)mid * mid;
            if (num == x) {
                return mid;
            } else if (num > x) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
