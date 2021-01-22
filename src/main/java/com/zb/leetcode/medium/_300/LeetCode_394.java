package com.zb.leetcode.medium._300;

import java.util.Stack;

/**
 * 394 字符串解码
 * @author Zhang Bo
 * @date 2021/1/22 17:06
 */
public class LeetCode_394 {

    //给定一个经过编码的字符串，返回它解码后的字符串。
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
//
//
//
// 示例 1：
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
//
//
// 示例 2：
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
//
//
// 示例 3：
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
//
//
// 示例 4：
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
//
// Related Topics 栈 深度优先搜索
// 👍 633 👎 0

    public String decodeString(String s) {
        int i = 0;
        Stack<String> stack = new Stack<>();
        while (i < s.length()) {
            if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                String st;
                while (!(st = stack.pop()).equals("[")) {
                    sb.insert(0, st);
                }
                st = sb.toString();
                int count = Integer.valueOf(stack.pop());
                while (count > 1) {
                    sb.append(st);
                    count--;
                }
                stack.push(sb.toString());
                i++;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                StringBuilder nsb = new StringBuilder();
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    nsb.append(s.charAt(i++));
                }
                stack.push(nsb.toString());
            }else{
                stack.push(s.substring(i, ++i));
            }
        }
        StringBuilder rs = new StringBuilder();
        for (String s1 : stack) {
            rs.append(s1);
        }
        return rs.toString();
    }
}
