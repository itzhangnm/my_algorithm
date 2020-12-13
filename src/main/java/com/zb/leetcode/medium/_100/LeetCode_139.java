package com.zb.leetcode.medium._100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * 139. 单词拆分
 * @author once
 * @date 2020/12/12 10:50
 *
 */
public class LeetCode_139 {
    /**
     * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     * <p>
     * 说明：
     * <p>
     * 拆分时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     * 示例 1：
     * <p>
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
     * 示例 2：
     * <p>
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     *      注意你可以重复使用字典中的单词。
     * 示例 3：
     * <p>
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/word-break
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_139 leetCode_139 = new LeetCode_139();
        System.out.println(leetCode_139.wordBreak("leetcode", Arrays.asList("leet", "code","hello")));
        System.out.println(leetCode_139.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(leetCode_139.wordBreak("catsandog", Arrays.asList("cats", "dog","sand", "and", "cat")));

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i]=dp[j]&& s.sub(j-i-1) = true
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
