package com.zb.leetcode.simple._300;

/**
 * 204. 计数质数
 *
 * @author Zhang Bo
 * @date 2020/6/2 11:05
 */
public class LeetCode_204 {

    /**
     * 统计所有小于非负整数 n 的质数的数量。
     * <p>
     * 示例:
     * <p>
     * 输入: 10
     * 输出: 4
     * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     */

    public static void main(String[] args) {
        LeetCode_204 leetCode204 = new LeetCode_204();
        System.out.println(leetCode204.countPrimes(10));
        System.out.println(leetCode204.countPrimes(20));
        System.out.println(leetCode204.countPrimes(499979));
        System.out.println(leetCode204.countPrimes(Integer.MAX_VALUE));
    }

    public int countPrimes(int n) {
//        return (int) IntStream.range(2, n).filter(x -> IntStream.range(2, (int) (Math.sqrt(x) + 1)).filter(y -> x % y == 0).count() == 0).count();
        boolean[] isPrim = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                continue;
            }
            count++;
            for (int j = i * 2; j < n; j += i) {
                isPrim[j] = true;
            }
        }
        return count;
    }

}
