package com.zb.leetcode.simple._200;

import java.util.HashMap;
import java.util.Map;

/**
 * 202. 快乐数
 *
 * @author Zhang Bo
 * @date 2020/6/2 11:05
 */
public class LeetCode_202 {

    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * <p>
     * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
     * <p>
     * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：19
     * 输出：true
     * 解释：
     * 1^2 + 9^2 = 82
     * 8^2 + 2^2 = 68
     * 6^2 + 8^2 = 100
     * 1^2 + 0^2 + 0^2 = 1
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/happy-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_202 leetCode202 = new LeetCode_202();
        System.out.println(leetCode202.isHappy(19));
        System.out.println(leetCode202.isHappy(2));
    }

    public boolean isHappy(int n) {
        Object o = new Object();
        Map<Integer, Object> map = new HashMap<>();
        map.put(n, o);
        while (n != 1) {
            int tmp = 0;
            while (n > 0) {
                tmp += (n % 10) * (n % 10);
                n /= 10;
            }
            if (map.get(tmp) != null) {
                return false;
            }else{
                map.put(tmp, o);
            }
            n = tmp;
        }
        return true;
    }
}
