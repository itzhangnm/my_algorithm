package com.zb.leetcode.simple._100;

import java.util.Stack;

/**
 * 20 有效的括号
 * @author Zhang Bo
 * @date 2019/11/13 16:06
 */
public class LeetCode_020 {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(c);
            } else if (check(stack.peek(), c)) {
                //括号匹配,将左括号弹出栈
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        //完全匹配,栈一定为空
        return stack.empty();
    }

    private boolean check(char lc, char rc) {
        return '(' == lc && ')' == rc || '[' == lc && ']' == rc || '{' == lc && '}' == rc;
    }
}
