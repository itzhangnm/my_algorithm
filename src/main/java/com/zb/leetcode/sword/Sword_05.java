package com.zb.leetcode.sword;

/***
 * 剑指 Offer 05. 替换空格
 * @author once
 * @date 2020/11/30 21:43
 *
 */
public class Sword_05 {

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     *  
     * <p>
     * 限制：
     * <p>
     * 0 <= s 的长度 <= 10000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     */
    public static void main(String[] args) {
        Sword_05 sword_05 = new Sword_05();
        System.out.println(sword_05.replaceSpace("We are happy."));
    }

    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[s.length() * 3];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                result[index++] = '%';
                result[index++] = '2';
                result[index++] = '0';
            }else{
                result[index++] = chars[i];
            }
        }
        return new String(result,0,index);
    }
}
