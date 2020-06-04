package com.zb.leetcode.simple._000;

/**
 * 14. 最长公共前缀
 *
 * @author Zhang Bo
 * @date 2020/5/29 18:23
 */
public class LeetCode_014 {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。

     如果不存在公共前缀，返回空字符串 ""。

     示例 1:

     输入: ["flower","flow","flight"]
     输出: "fl"
     示例 2:

     输入: ["dog","racecar","car"]
     输出: ""
     解释: 输入不存在公共前缀。
     说明:

     所有输入只包含小写字母 a-z 。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/longest-common-prefix
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_014 leetCode014 = new LeetCode_014();
        System.out.println(leetCode014.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(leetCode014.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
    public String longestCommonPrefix(String[] strs) {
//        if (strs.length < 1) {
//            return "";
//        }
//        StringBuilder result = new StringBuilder();
//        int i = 1;
//        while (true) {
//            for (String str : strs) {
//                if (str.length() < i || strs[0].charAt(i - 1) != str.charAt(i - 1)) {
//                    return result.toString();
//                }
//            }
//            result.append(strs[0].charAt(i - 1));
//            i++;
//        }
        if (strs.length < 1) {
            return "";
        }
        String prefix = strs[0];
        for (String str : strs) {
            while (!str.startsWith(prefix)) {
                if (prefix.length() == 1) {
                    return "";
                }
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

}
