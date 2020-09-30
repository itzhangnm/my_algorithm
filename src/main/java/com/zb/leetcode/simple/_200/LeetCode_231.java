package com.zb.leetcode.simple._200;

/***
 * 231. 2的幂
 * @author once
 * @date 2020/9/30 20:56
 *
 */
public class LeetCode_231 {
    /**
     * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1
     * 输出: true
     * 解释: 2^0 = 1
     * 示例 2:
     * <p>
     * 输入: 16
     * 输出: true
     * 解释: 2^4 = 16
     * 示例 3:
     * <p>
     * 输入: 218
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/power-of-two
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_231 leetCode_231 = new LeetCode_231();
        System.out.println(leetCode_231.isPowerOfTwo(1));
        System.out.println(leetCode_231.isPowerOfTwo(16));
        System.out.println(leetCode_231.isPowerOfTwo(218));
    }

    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        long x = (long) n;
//        return (x & (-x) == n;
        return (x & (x - 1)) == 0;
    }
}
