package com.zb.leetcode.medium._000;

/**
 * 96. 不同的二叉搜索树
 * @author Zhang Bo
 * @date 2020/12/7 17:51
 */
public class LeetCode_096 {

    /**
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

     示例:

     输入: 3
     输出: 5
     解释:
     给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

     1         3     3      2      1
     \       /     /      / \      \
     3     2     1      1   3      2
     /     /       \                 \
     2     1         2                 3

     来源：力扣（LeetCode_148）
     链接：https://leetcode-cn.com/problems/unique-binary-search-trees
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_096 leetCode_096 = new LeetCode_096();
        System.out.println(leetCode_096.numTrees(1));
        System.out.println(leetCode_096.numTrees(2));
        System.out.println(leetCode_096.numTrees(3));
        System.out.println(leetCode_096.numTrees(4));
    }

    public int numTrees(int n) {
        int[] rs = new int[n + 1];
        rs[0] = 1;
        rs[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                rs[i] += rs[j - 1] * rs[i - j];
            }
        }
        return rs[n];
    }
}
