package com.zb.leetcode.simple._300;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * @author Zhang Bo
 * @date 2020/6/2 11:05
 */
public class LeetCode_387 {

    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

      

     示例：

     s = "leetcode"
     返回 0

     s = "loveleetcode"
     返回 2
      

     提示：你可以假定该字符串只包含小写字母。

     来源：力扣（LeetCode_148）
     链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {

    }

    public int firstUniqChar(String s) {
//        char[] chars = s.toCharArray();
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < chars.length; i++) {
//            if (map.containsKey(chars[i])) {
//                map.put(chars[i], map.get(chars[i]) + 1);
//            }else{
//                map.put(chars[i],1);
//            }
//        }
//        for (int i = 0; i < chars.length; i++) {
//            if (map.get(chars[i]) == 1) {
//                return i;
//            }
//        }
//        return -1;
        int result = s.length();
        for (int i = 'a'; i < 'z'; i++) {
            int index = s.indexOf(i);
            if (index >= 0 && index == s.lastIndexOf(i)) {
                result = index < result ? index : result;
            }
        }
        return result == s.length() ? -1 : result;
    }
}
