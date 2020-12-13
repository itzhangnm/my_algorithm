package com.zb.leetcode.medium._1200;

import java.util.Stack;

/**
 * 1249.移除无效的括号
 * @author Zhang Bo
 * @date 2019/11/18 15:54
 */
public class LeetCode_1249 {
    /**
     * 给你一个由 '('、')' 和小写字母组成的字符串 s。
     * <p>
     * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
     * <p>
     * 请返回任意一个合法字符串。
     * <p>
     * 有效「括号字符串」应当符合以下 任意一条 要求：
     * <p>
     * 空字符串或只包含小写字母的字符串
     * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
     * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "lee(t(c)o)de)"
     * 输出："lee(t(c)o)de"
     * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
     * 示例 2：
     * <p>
     * 输入：s = "a)b(c)d"
     * 输出："ab(c)d"
     * 示例 3：
     * <p>
     * 输入：s = "))(("
     * 输出：""
     * 解释：空字符串也是有效的
     * 示例 4：
     * <p>
     * 输入：s = "(a(b(c)d)"
     * 输出："a(b(c)d)"
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 10^5
     * s[i] 可能是 '('、')' 或英文小写字母
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_1249 leetCode_1249 = new LeetCode_1249();
        System.out.println(leetCode_1249.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(leetCode_1249.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(leetCode_1249.minRemoveToMakeValid("))(("));
        System.out.println(leetCode_1249.minRemoveToMakeValid("(a(b(c)d)"));
    }

    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        boolean[] isDelete = new boolean[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                //'('未匹配到')',先标记为删除
                stack.push(i);
                isDelete[i] = true;
            } else if (chars[i] == ')') {
                // ')' stack证明左边未有')',不用压栈,直接记录为删除
                if (stack.isEmpty()) {
                    isDelete[i] = true;
                } else {
                    //stack存在,证明匹配到了(),将栈顶弹出,且修改标记为不删除
                    isDelete[stack.pop()] = false;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (!isDelete[i]) {
                result.append(chars[i]);
            }
        }
        return result.toString();
    }
}
