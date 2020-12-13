package com.zb.leetcode.medium._100;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 *
 * @author Zhang Bo
 * @date 2020/12/4 17:14
 */
public class LeetCode_131 {

    /**
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     * <p>
     * 返回 s 所有可能的分割方案。
     * <p>
     * 示例:
     * <p>
     * 输入: "aab"
     * 输出:
     * [
     * ["aa","b"],
     * ["a","a","b"]
     * ]
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_131 leetCode_131 = new LeetCode_131();
        System.out.println(leetCode_131.partition("aab"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
//        backPartition(res, tmp, 0, s.length(), s);
        //动态规划模式
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int right = 0; right < s.length(); right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        backPartition(res, tmp, dp, 0, s.length(), s);

        return res;
    }

    private void backPartition(List<List<String>> res, List<String> tmp, boolean[][] dp, int start, int end, String s) {
        if (start == end) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < end; i++) {
            if (!dp[start][i]) {
                continue;
            }
            tmp.add(s.substring(start, i + 1));
            backPartition(res, tmp, dp, i + 1, end, s);
            tmp.remove(tmp.size() - 1);
        }
    }

//    private void backPartition(List<List<String>> res, List<String> tmp, int start, int end, String s) {
//        if (start == end) {
//            res.add(new ArrayList<>(tmp));
//            return;
//        }
//
//        for (int i = start + 1; i <= end; i++) {
//            String preStr = s.substring(start, i);
//            if (!checkPartition(preStr)) {
//                continue;
//            }
//            tmp.add(preStr);
//            backPartition(res,tmp,i,end ,s);
//            tmp.remove(tmp.size() - 1);
//        }
//    }
//
//    private boolean checkPartition(String s) {
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] != chars[chars.length - i - 1]) {
//                return false;
//            }
//        }
//        return true;
//    }
}
