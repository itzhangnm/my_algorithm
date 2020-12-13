package com.zb.leetcode.medium._000;

/***
 * 79. 单词搜索
 * @author once
 * @date 2020/11/14 11:16
 *
 */
public class LeetCode_079 {

    /**
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * <p>
     * 给定 word = "ABCCED", 返回 true
     * 给定 word = "SEE", 返回 true
     * 给定 word = "ABCB", 返回 false
     *  
     * <p>
     * 提示：
     * <p>
     * board 和 word 中只包含大写和小写英文字母。
     * 1 <= board.length <= 200
     * 1 <= board[i].length <= 200
     * 1 <= word.length <= 10^3
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/word-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public boolean exist(char[][] board, String word) {
        boolean[][] useds = new boolean[board.length][200];
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (nextExist(board, useds, chars, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean nextExist(char[][] board, boolean[][] useds, char[] chars, int index, int i, int j) {
        if (index >= chars.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
            return false;
        }
        boolean flag = false;
        if (!useds[i][j] && board[i][j] == chars[index]) {
            useds[i][j] = true;
            flag = nextExist(board, useds, chars, index + 1, i + 1, j) ||
                    nextExist(board, useds, chars, index + 1, i - 1, j) ||
                    nextExist(board, useds, chars, index + 1, i, j + 1) ||
                    nextExist(board, useds, chars, index + 1, i, j - 1);
            useds[i][j] = false;
        }
        return flag;
    }
}
