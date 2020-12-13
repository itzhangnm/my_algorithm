package com.zb.leetcode.simple._000;

/***
 * 67. 二进制求和
 * @author once
 * @date 2020/9/12 21:37
 *
 */
public class LeetCode_067 {
    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     *
     * 输入为 非空 字符串且只包含数字 1 和 0。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 示例 2:
     *
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     *  
     *
     * 提示：
     *
     * 每个字符串仅由字符 '0' 或 '1' 组成。
     * 1 <= a.length, b.length <= 10^4
     * 字符串如果不是 "0" ，就都不含前导零。
     *
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/add-binary
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_067 leetCode067 = new LeetCode_067();
        System.out.println(leetCode067.addBinary("11", "1"));
        System.out.println(leetCode067.addBinary("1010", "1011"));
        System.out.println(leetCode067.addBinary("111100110", "10101"));
    }

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        int[] nums = new int[a.length() + 1];
        int temp = a.length() - b.length();
        for (int i = nums.length - 1; i > 0; i--) {
            if (a.charAt(i - 1) == '1') {
                nums[i]++;
            }
            if (i > temp && b.charAt(i - 1 - temp) == '1') {
                nums[i]++;
            }
            if (nums[i] > 1) {
                nums[i - 1]++;
            }
        }
        StringBuilder sb = nums[0] == 0 ? new StringBuilder() : new StringBuilder("1");
        for (int i = 1; i < nums.length; i++) {
            sb.append(nums[i] % 2 == 0 ? "0" : "1");
        }
        return sb.toString();
    }
}
