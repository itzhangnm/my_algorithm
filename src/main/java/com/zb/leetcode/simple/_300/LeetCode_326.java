package com.zb.leetcode.simple._300;

/**
 * 326. 3的幂
 *
 * @author Zhang Bo
 * @date 2020/6/2 11:05
 */
public class LeetCode_326 {

    /**
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。

     示例 1:

     输入: 27
     输出: true
     示例 2:

     输入: 0
     输出: false
     示例 3:

     输入: 9
     输出: true
     示例 4:

     输入: 45
     输出: false
     进阶：
     你能不使用循环或者递归来完成本题吗？

     来源：力扣（LeetCode_148）
     链接：https://leetcode-cn.com/problems/power-of-three
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_326 leetCode326 = new LeetCode_326();
        System.out.println(leetCode326.isPowerOfThree(3));
        System.out.println(leetCode326.isPowerOfThree(4));
        System.out.println(leetCode326.isPowerOfThree(9));
        System.out.println(leetCode326.isPowerOfThree(27));
        System.out.println(leetCode326.isPowerOfThree(28));
        System.out.println(leetCode326.isPowerOfThree(128));
    }

    public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("^10*$");

    }

}
