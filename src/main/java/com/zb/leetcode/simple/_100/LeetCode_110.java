package com.zb.leetcode.simple._100;

import com.zb.leetcode.TreeNode;

/**
 * 110. 平衡二叉树
 *
 * @author Zhang Bo
 * @date 2020/10/10 10:43
 */
public class LeetCode_110 {

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight, rightHeight;
        if ((leftHeight = height(node.left)) == -1 || (rightHeight = height(node.right)) == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
