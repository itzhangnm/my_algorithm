package com.zb.leetcode.medium._000;

import java.util.ArrayList;
import java.util.List;

/***
 * 22. 括号生成
 * @author once
 * @date 2020/9/8 23:06
 *
 */
public class LeetCode_022 {

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     *  
     *
     * 示例：
     *
     * 输入：n = 3
     * 输出：[
     *        "((()))",
     *        "(()())",
     *        "(())()",
     *        "()(())",
     *        "()()()"
     *      ]
     *
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/generate-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_022 leetCode022 = new LeetCode_022();
        System.out.println(leetCode022.generateParenthesis(2));
        System.out.println(leetCode022.generateParenthesis(3));
        System.out.println(leetCode022.generateParenthesis(4));
    }

    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        backParenthesis(result, 1, 0, n, new StringBuilder("("));
        return result;
    }

    private void backParenthesis(ArrayList<String> result, int left, int right, int n, StringBuilder sb) {
        if (right > left) {
            return;
        }
        if (right == n) {
            result.add(sb.toString());
        }else{
            if (left < n) {
                backParenthesis(result, left + 1, right, n, sb.append("("));
                sb.deleteCharAt(sb.length() - 1);
            }
            if (right < n) {
                backParenthesis(result, left, right + 1, n, sb.append(")"));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
