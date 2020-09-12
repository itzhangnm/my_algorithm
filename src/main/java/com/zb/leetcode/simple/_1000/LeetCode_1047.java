package com.zb.leetcode.simple._1000;

import java.util.Stack;

/***
 * 1047.删除字符串中的所有相邻重复项
 * @author once
 * @date 2019/11/15 20:31
 *
 */
public class LeetCode_1047 {

    /**
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     * <p>
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     * <p>
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入："abbaca"
     * 输出："ca"
     * 解释：
     * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= S.length <= 20000
     * S 仅由小写英文字母组成。
     */

    public static void main(String[] args) {
        LeetCode_1047 leetCode_1047 = new LeetCode_1047();
        System.out.println(leetCode_1047.removeDuplicates("abbaca"));
    }

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                //为空或不同压栈
                stack.push(c);
                result.append(c);
            } else {
                //相同,出栈且删除最后一位
                stack.pop();
                result.delete(result.length() - 1, result.length());
            }
        }
        return result.toString();
    }
}
