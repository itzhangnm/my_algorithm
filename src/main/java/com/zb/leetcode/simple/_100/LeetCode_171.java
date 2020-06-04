package com.zb.leetcode.simple._100;

/**
 * 171. Excel表列序号
 *
 * @author Zhang Bo
 * @date 2020/6/2 11:05
 */
public class LeetCode_171 {

    /**
     * 给定一个Excel表格中的列名称，返回其相应的列序号。
     * <p>
     * 例如，
     * <p>
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     * 示例 1:
     * <p>
     * 输入: "A"
     * 输出: 1
     * 示例 2:
     * <p>
     * 输入: "AB"
     * 输出: 28
     * 示例 3:
     * <p>
     * 输入: "ZY"
     * 输出: 701
     * 致谢：
     * 特别感谢 @ts 添加此问题并创建所有测试用例。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_171 leetCode171 = new LeetCode_171();
        System.out.println(leetCode171.titleToNumber("A"));
        System.out.println(leetCode171.titleToNumber("AB"));
        System.out.println(leetCode171.titleToNumber("ZY"));
        System.out.println(2 ^ 2);
    }


    public int titleToNumber(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            result += Math.pow(('Z' - 64), chars.length - i - 1) * (chars[i] - 64);
        }
        return result;
    }
}
