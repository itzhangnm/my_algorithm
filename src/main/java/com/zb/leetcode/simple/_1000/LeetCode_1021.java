package com.zb.leetcode.simple._1000;

import java.util.Stack;

/**
 * 1021.删除最外层的括号
 * @author Zhang Bo
 * @date 2019/11/15 14:35
 */
public class LeetCode_1021 {

    /**
     * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
     * <p>
     * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
     * <p>
     * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
     * <p>
     * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入："(()())(())"
     * 输出："()()()"
     * 解释：
     * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
     * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
     * 示例 2：
     * <p>
     * 输入："(()())(())(()(()))"
     * 输出："()()()()(())"
     * 解释：
     * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
     * 删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
     * 示例 3：
     * <p>
     * 输入："()()"
     * 输出：""
     * 解释：
     * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
     * 删除每个部分中的最外层括号后得到 "" + "" = ""。
     *  
     * <p>
     * 提示：
     * <p>
     * S.length <= 10000
     * S[i] 为 "(" 或 ")"
     * S 是一个有效括号字
     */

    public static void main(String[] args) {
        LeetCode_1021 leetCode_1021 = new LeetCode_1021();
        System.out.println(leetCode_1021.removeOuterParentheses("(()())(())"));
        System.out.println(leetCode_1021.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(leetCode_1021.removeOuterParentheses("()()"));
    }

    public String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int start = 0;
        int index = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                //左括号压栈
                stack.push(c);
            }else{
                //右括号压栈
                stack.pop();
            }
            //左右一定对称
            if (stack.isEmpty()) {
                //去除最外层括号即截取开始位置加一到右括号对应位置
                result.append(S, start + 1, index);
                //更新起始位置
                start = index + 1;
            }
            index++;
        }
        return result.toString();
    }
}
