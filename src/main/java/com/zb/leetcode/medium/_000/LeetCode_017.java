package com.zb.leetcode.medium._000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 17. 电话号码的字母组合
 * @author once
 * @date 2020/9/8 22:37
 *
 */
public class LeetCode_017 {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * 说明:
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_017 leetCode017 = new LeetCode_017();
        System.out.println(leetCode017.letterCombinations("23"));
        System.out.println(leetCode017.letterCombinations("245"));
    }

    private Map<Character, String> dictMaps = initDictMaps();

    private Map<Character, String> initDictMaps() {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mon");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() < 1) {
            return result;
        }
        backSplice(result, digits, 0, new StringBuilder());
        return result;
    }

    private void backSplice(List<String> result, String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
        } else {
            String strs = dictMaps.get(digits.charAt(index));
            for (int i = 0; i < strs.length(); i++) {
                sb.append(strs.charAt(i));
                backSplice(result, digits, index + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
