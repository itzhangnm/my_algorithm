package com.zb.leetcode.simple._200;

/***
 *
 * 268.缺失数字
 * @author once
 * @date 2019/12/7 10:31
 *
 */
public class LeetCode_268 {

    /**
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     *
     * 示例 1:
     *
     * 输入: [3,0,1]
     * 输出: 2
     * 示例 2:
     *
     * 输入: [9,6,4,2,3,5,7,0,1]
     * 输出: 8
     * 说明:
     * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
     *
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/missing-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_268 leetCode_268 = new LeetCode_268();
        System.out.println(leetCode_268.missingNumber(new int[]{3,0,1}));
        System.out.println(leetCode_268.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
    public int missingNumber(int[] nums) {
        //求和存在溢出
//        int tmp = nums.length;
//        for (int i = 0; i < nums.length; i++) {
//            tmp = tmp + i - nums[i];
//        }
//        return  tmp;
        //异或方法
        int tmp = nums.length;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= i ^ nums[i];
        }
        return tmp;
    }
}
