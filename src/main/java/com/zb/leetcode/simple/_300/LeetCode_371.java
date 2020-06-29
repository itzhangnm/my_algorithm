package com.zb.leetcode.simple._300;

/**
 * 371. 两整数之和
 *
 * @author Zhang Bo
 * @date 2020/6/2 11:05
 */
public class LeetCode_371 {

    /**
     * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。

     示例 1:

     输入: a = 1, b = 2
     输出: 3
     示例 2:

     输入: a = -2, b = 3
     输出: 1

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/sum-of-two-integers
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_371 leetCode371 = new LeetCode_371();
        System.out.println(Integer.toUnsignedString(-1,2));
        System.out.println(Integer.toUnsignedString(1,2));
        System.out.println(Integer.toUnsignedString(-2,2));
    }

    public int getSum(int a, int b) {
        int r = a ^ b;
        b &= a;
        while (b != 0) {
            b = b << 1;
            a = r;
            r ^= b;
            b &= a;
        }
        return r;
    }
}
