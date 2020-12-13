package com.zb.leetcode.simple._600;

/***
 *
 * @author once
 * @date 2019/12/15 14:50
 *
 */
public class LeetCode_628 {

    /**
     * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3]
     * 输出: 6
     * 示例 2:
     * <p>
     * 输入: [1,2,3,4]
     * 输出: 24
     * 注意:
     * <p>
     * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
     * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maximumProduct(int[] nums) {
        int m1, m2, m3;
        m1 = m2 = m3 = Integer.MIN_VALUE;
        int n1,n2;
        n1 = n2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > m3) {
                m1 = m2;
                m2 = m3;
                m3 = num;
            } else if (num >= m2) {
                m1 = m2;
                m2 = num;
            } else if (num >= m1) {
                m1 = num;
            }
            if (num < n2) {
                n1 = n2;
                n2 = num;
            } else if (num < n1) {
                n1 = num;
            }
        }
        return Math.max(n1 * n2 * m3, m1 * m2 * m3);
    }

}
