package com.zb.leetcode.medium._000;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 49. 字母异位词分组
 * @author Zhang Bo
 * @date 2020/11/11 16:34
 */
public class LeetCode_049 {
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

     示例:

     输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     输出:
     [
     ["ate","eat","tea"],
     ["nat","tan"],
     ["bat"]
     ]
     说明：

     所有输入均为小写字母。
     不考虑答案输出的顺序。

     来源：力扣（LeetCode_148）
     链接：https://leetcode-cn.com/problems/group-anagrams
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_049 leetCode_049 = new LeetCode_049();
        System.out.println(JSON.toJSONString(leetCode_049.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})));
        System.out.println(JSON.toJSONString(leetCode_049.groupAnagrams(new String[]{"bdddddddddd", "bbbbbbbbbbc"})));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            int[] tmp = new int[26];
            for (char c : str.toCharArray()) {
                tmp[c - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for (int i : tmp) {
                sb.append(i).append("-");
            }
            String key = sb.toString();
            System.out.println(key);
            if (result.get(key) == null) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(str);
        }
        return new ArrayList<>(result.values());
    }

}
