package com.zb.leetcode.medium._000;

/***
 * 5. 最长回文子串
 * @author once
 * @date 2020/9/12 10:19
 *
 */
public class LeetCode_005 {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_005 leetCode005 = new LeetCode_005();
        System.out.println(leetCode005.longestPalindrome("babad"));
        System.out.println(leetCode005.longestPalindrome("cbbd"));
        System.out.println(leetCode005.longestPalindrome("abb"));
    }

    public String longestPalindrome(String s) {
        String str = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i + l < s.length(); i++) {
                //表示当前字符串长度如: abcdefg -> l = 1 即为ab,bc,cd,de,ef,fg
                int j = i + l;
                boolean b = s.charAt(i) == s.charAt(j);
                if (l <= 1) {
                    dp[i][j] = b;
                }else {
                    dp[i][j] = b && dp[i + 1][j - 1];
                }
                if (dp[i][j] && l + 1 > str.length()) {
                    str = s.substring(i, j + 1);
                }
            }
        }
        return str;
    }

}
