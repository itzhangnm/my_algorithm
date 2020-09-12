package com.zb.leetcode.medium._1200;

import java.util.Stack;

/***
 * 1209.删除字符串中的所有相邻重复项 II
 * @author once
 * @date 2019/11/16 10:45
 *
 */
public class LeetCode_1209 {

    /**
     *给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
     *
     * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
     *
     * 在执行完所有删除操作后，返回最终得到的字符串。
     *
     * 本题答案保证唯一。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "abcd", k = 2
     * 输出："abcd"
     * 解释：没有要删除的内容。
     * 示例 2：
     *
     * 输入：s = "deeedbbcccbdaa", k = 3
     * 输出："aa"
     * 解释：
     * 先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
     * 再删除 "bbb"，得到 "dddaa"
     * 最后删除 "ddd"，得到 "aa"
     * 示例 3：
     *
     * 输入：s = "pbbcggttciiippooaais", k = 2
     * 输出："ps"
     *  
     *
     * 提示：
     *
     * 1 <= s.length <= 10^5
     * 2 <= k <= 10^4
     * s 中只含有小写英文字母。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_1209 leetCode_1209 = new LeetCode_1209();
        System.out.println(leetCode_1209.removeDuplicates("abcd",2));
        System.out.println(leetCode_1209.removeDuplicates("deeedbbcccbdaa",3));
        System.out.println(leetCode_1209.removeDuplicates("pbbcggttciiippooaais",2));
        System.out.println(leetCode_1209.removeDuplicates("kadzdobzlkjpwdgyxlwnhsgcscdcevctexzshhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvhhhhhhhggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvgggggggggggggggggggggddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddggggghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhouajljnqjlllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllliuvunwyqecebyowhmuwyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyzzhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyycbkniwdgdmkbvzsvwdgtyapmdbfhsudxalaw",100));
    }

    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        //记录每个字符出现次数
        int[] charIndexCount = new int[s.length()];
        //栈顶字符在数组中的位置
        int index = -1;
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                //达到条件，出栈
                if (charIndexCount[index] == k - 1) {
                    stack.pop();
                    //栈顶发生变化
                    index--;
                }else {
                    //栈顶字符重复，次数加1
                    charIndexCount[index] = charIndexCount[index] + 1;
                }
            }else{
                //栈顶发生变化
                index++;
                stack.push(c);
                charIndexCount[index] = 1;
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            char tmp = stack.pop();
            //添加栈内每个字符出现次数
            for (int i = 0; i < charIndexCount[index]; i++) {
                result.append(tmp);
            }
            index--;
        }
        return result.reverse().toString();
    }
}
