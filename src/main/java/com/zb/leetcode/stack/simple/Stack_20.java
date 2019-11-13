package com.zb.leetcode.stack.simple;

import java.util.Stack;

/**
 * @author Zhang Bo
 * @date 2019/11/13 16:06
 */
public class Stack_20 {

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
        if (s.length() == 0) {
            return true;
        }
        Stack<String> stack = new Stack<>();
        String[] arr = s.split("");
        for (String a : arr) {
            if ("(".equals(a) || "{".equals(a) || "[".equals(a)) {
                stack.push(a);
            } else if (")".equals(a) || "}".equals(a) || "]".equals(a)) {
                if (stack.empty() || !check(stack.pop(), a)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private boolean check(String ls, String rs) {
        if ("{".equals(ls) && "}".equals(rs)) {
            return true;
        } else if ("[".equals(ls) && "]".equals(rs)) {
            return true;
        } else if ("(".equals(ls) && ")".equals(rs)) {
            return true;
        }
        return false;
    }
}
