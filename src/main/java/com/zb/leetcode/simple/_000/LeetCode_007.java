package com.zb.leetcode.simple._000;

/**
 * 7. 整数反转
 * @author Zhang Bo
 * @date 2019/11/19 10:25
 */
public class LeetCode_007 {

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

     示例 1:

     输入: 123
     输出: 321
      示例 2:

     输入: -123
     输出: -321
     示例 3:

     输入: 120
     输出: 21
     注意:

     假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

     来源：力扣（LeetCode_148）
     链接：https://leetcode-cn.com/problems/reverse-integer
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_007 leetCode007 = new LeetCode_007();
        System.out.println(leetCode007.reverse(123));
        System.out.println(leetCode007.reverse(-123));
        System.out.println(leetCode007.reverse(120));
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (x > 0) {
                if (Integer.MAX_VALUE / 10 < result || (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < x % 10)) {
                    return 0;
                }
            }else{
                if (Integer.MIN_VALUE / 10 > result || (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 > x % 10)) {
                    return 0;
                }
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }

}
