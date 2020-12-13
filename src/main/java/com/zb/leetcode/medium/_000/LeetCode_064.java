package com.zb.leetcode.medium._000;

/**
 * 64. 最小路径和
 *
 * @author Zhang Bo
 * @date 2020/12/7 17:08
 */
public class LeetCode_064 {
    /**
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * <p>
     * 说明：每次只能向下或者向右移动一步。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     * 示例 2：
     * <p>
     * 输入：grid = [[1,2,3],[4,5,6]]
     * 输出：12
     *  
     * <p>
     * 提示：
     * <p>
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 200
     * 0 <= grid[i][j] <= 100
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/minimum-path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_064 leetCode_064 = new LeetCode_064();
        System.out.println(leetCode_064.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
        System.out.println(leetCode_064.minPathSum(new int[][]{{1,2,3},{4,5,6}}));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rs = new int[m][n];
        rs[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lastMin = 0;
                if (i > 0 && j > 0) {
                    lastMin =  rs[i - 1][j] > rs[i][j - 1] ?  rs[i][j - 1] : rs[i - 1][j];
                } else if (i > 0) {
                    lastMin = rs[i - 1][j];
                }else if (j > 0){
                    lastMin = rs[i][j - 1];
                }
                rs[i][j] = grid[i][j] + lastMin;
            }
        }
        return rs[m - 1][n - 1];
    }
}
