package com.zb.leetcode.simple._000;

/**
 * 28. 实现 strStr()
 *
 * @author Zhang Bo
 * @date 2020/5/29 18:23
 */
public class LeetCode_028 {
    /**
     * 实现 strStr() 函数。

     给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

     示例 1:

     输入: haystack = "hello", needle = "ll"
     输出: 2
     示例 2:

     输入: haystack = "aaaaa", needle = "bba"
     输出: -1
     说明:

     当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

     对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

     来源：力扣（LeetCode_148）
     链接：https://leetcode-cn.com/problems/implement-strstr
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_028 leetCode028 = new LeetCode_028();
        System.out.println(leetCode028.strStr("hello", "ll"));
        System.out.println(leetCode028.strStr("aaaaa", "aaaaa"));
        System.out.println(leetCode028.strStr("aaabbaa", "bba"));
        System.out.println(leetCode028.strStr("123", ""));
    }

    public int strStr(String haystack, String needle) {
//        if (needle.length() < 1) {
//            return 0;
//        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            String s = haystack.substring(i, i + needle.length());
            if (s.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

}
