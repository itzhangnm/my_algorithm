package com.zb.leetcode.sort.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhang Bo
 * @date 2019/11/13 15:46
 */
public class Sort_242 {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 说明:
     * 你可以假设字符串只包含小写字母。
     * <p>
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     */
    public static void main(String[] args) {
        Sort_242 sort_242 = new Sort_242();
        System.out.println(sort_242.isAnagram("anagram","nagaram"));
        System.out.println(sort_242.isAnagram("rat","car"));
    }
    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        Map<Character, Integer> mapS = conversionMap(s);
//        Map<Character, Integer> mapT = conversionMap(t);
//        if (mapS.size() != mapT.size()) {
//            return false;
//        }
//        for (Character character : mapT.keySet()) {
//            if (mapS.get(character) == null || !mapT.get(character).equals(mapS.get(character))) {
//                return false;
//            }
//        }
//        return true;
        //直接排序,效率更高
//        if (s.length() != t.length()) {
//            return false;
//        }
//        char[] charsA = s.toCharArray();
//        char[] charsT = t.toCharArray();
//        Arrays.sort(charsA);
//        Arrays.sort(charsT);
//        for (int i = 0; i < charsA.length; i++) {
//            if (charsA[i] != charsT[i]) {
//                return false;
//            }
//        }
//        return true;
        int[] nums = new int[128];
        char[] charsA = s.toCharArray();
        for (char c : charsA) {
            nums[c]++;
        }
        char[] charsT = t.toCharArray();
        for (char c : charsT) {
            nums[c]--;
        }
        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }
        return true;
        //最快用数组
    }

    private Map<Character, Integer> conversionMap(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.get(chars[i]) == null ? 1 : map.get(chars[i]) + 1);
        }
        return map;
    }

}
