package com.zb.leetcode.simple._400;

/***
 * 461. 汉明距离
 * @author once
 * @date 2020/11/7 22:38
 *
 */
public class LeetCode_461 {
    /**
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     *
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     *
     * 注意：
     * 0 ≤ x, y < 231.
     *
     * 示例:
     *
     * 输入: x = 1, y = 4
     *
     * 输出: 2
     *
     * 解释:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     *
     * 上面的箭头指出了对应二进制位不同的位置。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/hamming-distance
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int hammingDistance(int x, int y) {
        int r = x ^ y;
        int count = 0;
        while (r != 0) {
            if ((r & 1) != 0) {
                count++;
            }
            r = r >> 1;
        }
        return count;
    }
}
