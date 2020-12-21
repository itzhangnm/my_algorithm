package com.zb.leetcode.medium._200;

/***
 * 221. 最大正方形
 * @author once
 * @date 2020/12/21 22:43
 *
 */
public class LeetCode_221 {
    /**
     * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：matrix = [
     * ["1","0","1","0","0"],
     * ["1","0","1","1","1"],
     * ["1","1","1","1","1"],
     * ["1","0","0","1","0"]]
     * 输出：4
     * 示例 2：
     * <p>
     * <p>
     * 输入：matrix = [["0","1"],["1","0"]]
     * 输出：1
     * 示例 3：
     * <p>
     * 输入：matrix = [["0"]]
     * 输出：0
     *  
     * <p>
     * 提示：
     * <p>
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 300
     * matrix[i][j] 为 '0' 或 '1'
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximal-square
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] dp = new int[m * n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int min = 0;
                if (matrix[i][j] == '1') {
                    dp[i * m + j] = 1;
                    if (i > 0 && j > 0) {
                        min = Math.min(dp[i * m + j - 1], dp[(i - 1) * m + j]);
                        min = Math.min(dp[(i - 1) * m + j - 1], min);
                    }
                    dp[i * m + j] = min + 1;
                    max = Math.max(max, min + 1);
                }
            }
        }
        return max * max;
    }
}
