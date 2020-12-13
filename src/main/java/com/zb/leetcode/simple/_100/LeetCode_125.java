package com.zb.leetcode.simple._100;

/**
 * 125. 验证回文串
 *
 * @author Zhang Bo
 * @date 2020/6/2 11:05
 */
public class LeetCode_125 {

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

     说明：本题中，我们将空字符串定义为有效的回文串。

     示例 1:

     输入: "A man, a plan, a canal: Panama"
     输出: true
     示例 2:

     输入: "race a car"
     输出: false

     来源：力扣（LeetCode_148）
     链接：https://leetcode-cn.com/problems/valid-palindrome
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_125 leetCode125 = new LeetCode_125();
        System.out.println(leetCode125.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(leetCode125.isPalindrome("race a car"));
        System.out.println(leetCode125.isPalindrome(" "));
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i <= j) {
            while (i < chars.length - 1 && !support(chars[i])) {
                i++;
            }
            while (j >= 0 && !support(chars[j])) {
                j--;
            }
            if (i > j) {
                break;
            }
            if (chars[i] == chars[j]) {
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    private boolean support(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }
}
