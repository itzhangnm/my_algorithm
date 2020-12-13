package com.zb.leetcode.simple._100;

/***
 * 168. Excel表列名称
 * @author once
 * @date 2020/9/13 10:54
 *
 */
public class LeetCode_168 {
    /**
     * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
     *
     * 例如，
     *
     *     1 -> A
     *     2 -> B
     *     3 -> C
     *     ...
     *     26 -> Z
     *     27 -> AA
     *     28 -> AB
     *     ...
     * 示例 1:
     *
     * 输入: 1
     * 输出: "A"
     * 示例 2:
     *
     * 输入: 28
     * 输出: "AB"
     * 示例 3:
     *
     * 输入: 701
     * 输出: "ZY"
     *
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        System.out.println(701 / 26);
        System.out.println(701 % 26);
        LeetCode_168 leetCode168 = new LeetCode_168();
        System.out.println(leetCode168.convertToTitle(1));
        System.out.println(leetCode168.convertToTitle(26));
        System.out.println(leetCode168.convertToTitle(27));
        System.out.println(leetCode168.convertToTitle(28));
        System.out.println(leetCode168.convertToTitle(701));
    }
    public String convertToTitle(int n) {
        String result = "";
        while (n > 0) {
            n--;
            result = (char)(n % 26 + 'A') + result;
            n /= 26;
        }
        return result;
    }
}
