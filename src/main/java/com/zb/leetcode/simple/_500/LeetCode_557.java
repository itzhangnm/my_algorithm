package com.zb.leetcode.simple._500;

/***
 * 557. 反转字符串中的单词 III
 * @author once
 * @date 2020/11/21 10:00
 *
 */
public class LeetCode_557 {

    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *
     *  
     *
     * 示例：
     *
     * 输入："Let's take LeetCode_148 contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     *  
     *
     * 提示：
     *
     * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     *
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_557 leetCode_557 = new LeetCode_557();
        System.out.println(leetCode_557.reverseWords("Let's take LeetCode_148 contest"));
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end;
        for (int i = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] == ' ') {
                end = i - 1;
                swap(chars, start, end);
                start = i + 1;
            }
        }
        return String.valueOf(chars);
    }

    private void swap(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
