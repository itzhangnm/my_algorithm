package com.zb.leetcode.simple._100;

import com.zb.leetcode.TreeNode;

/***
 * 111. 二叉树的最小深度
 * @author once
 * @date 2020/10/15 23:02
 *
 */
public class LeetCode_111 {
    /**
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     *
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最小深度  2.
     *
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        return minHeight(root);
    }

    private int minHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMin = minHeight(node.left);
        int rightMin = minHeight(node.right);
        if (leftMin == 0) {
            return rightMin + 1;
        } else if (rightMin == 0) {
            return leftMin + 1;
        }else{
            return Math.min(leftMin, rightMin) + 1;
        }
    }
}
