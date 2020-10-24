package com.zb.leetcode.simple._400;

import com.zb.leetcode.TreeNode;

/***
 * 计算给定二叉树的所有左叶子之和。
 * @author once
 * @date 2020/10/24 17:10
 *
 */
public class LeetCode_404 {
    /**
     * 计算给定二叉树的所有左叶子之和。
     *
     * 示例：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     *  
     *
     * 通过次数59,979提交次数106,803
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftSum = root.left.val;
        }
        return leftSum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
