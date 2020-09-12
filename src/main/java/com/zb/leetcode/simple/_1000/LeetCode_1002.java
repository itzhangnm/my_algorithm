package com.zb.leetcode.simple._1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 查找常用字符
 * @author Zhang Bo
 * @date 2020/1/3 15:20
 */
public class LeetCode_1002 {

    /**
     * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。

     你可以按任意顺序返回答案。

      

     示例 1：

     输入：["bella","label","roller"]
     输出：["e","l","l"]
     示例 2：

     输入：["cool","lock","cook"]
     输出：["c","o"]
      

     提示：

     1 <= A.length <= 100
     1 <= A[i].length <= 100
     A[i][j] 是小写字母

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/find-common-characters
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_1002 leetCode_1002 = new LeetCode_1002();
        System.out.println(leetCode_1002.commonChars(new String[]{"bella","label","roller"}));
        System.out.println(leetCode_1002.commonChars(new String[]{"cool","lock","cook"}));
    }

    public List<String> commonChars(String[] A) {
        int[] r = new int[26];
        for (int i = 0; i < r.length; i++) {
            r[i] = 101;
        }
        int[] tmp;
        for (int i = 0; i < A.length; i++) {
            tmp = new int[26];
            char[] chars = A[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                tmp[chars[j] - 97]+=1;
            }
            for (int j = 0; j < r.length; j++) {
                r[j] = r[j] <= tmp[j] ? r[j] : tmp[j];
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < r.length; i++) {
            int count = r[i];
            while (count > 0) {
                result.add((char) (i + 97) + "");
                count--;
            }
        }
        return result;
    }

    //    public List<String> commonChars(String[] A) {
//        Map<Character, Map<Integer, Integer>> map = new HashMap<>();
//        for (int i = 0; i < A.length; i++) {
//            char[] chars = A[i].toCharArray();
//            for (int j = 0; j < chars.length; j++) {
//                Map<Integer, Integer> subMap;
//                if (map.get(chars[j]) != null) {
//                    subMap= map.get(chars[j]);
//                    if (subMap.get(i) != null) {
//                        subMap.put(i, subMap.get(i) + 1);
//                    }else{
//                        subMap.put(i, 1);
//                    }
//                }else{
//                    subMap = new HashMap<>();
//                    subMap.put(i, 1);
//                }
//                map.put(chars[j], subMap);
//            }
//        }
//        List<String> result = new ArrayList<>();
//        for (Character key : map.keySet()) {
//            if (map.get(key).size() == A.length) {
//                Map<Integer, Integer> subMap = map.get(key);
//                int min = Integer.MAX_VALUE;
//                for (Integer val : subMap.values()) {
//                    if (val < min) {
//                        min = val;
//                    }
//                }
//                while (min > 0) {
//                    result.add(key + "");
//                    min--;
//                }
//            }
//        }
//        return result;
//    }
}
