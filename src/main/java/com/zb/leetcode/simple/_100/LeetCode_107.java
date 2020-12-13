package com.zb.leetcode.simple._100;

import com.zb.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * 107. 二叉树的层次遍历 II
 * @author once
 * @date 2020/9/12 23:53
 *
 */
public class LeetCode_107 {
    /**
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其自底向上的层次遍历为：
     *
     * [
     *   [15,7],
     *   [9,20],
     *   [3]
     * ]
     *
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        LeetCode_107 leetCode107 = new LeetCode_107();
        System.out.println(leetCode107.levelOrderBottom(node));
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        currentLevel(root, 1, result);
        Collections.reverse(result);
        return result;
    }

    private void currentLevel(TreeNode node, int level, List<List<Integer>> list) {
        if (node == null) {
            return;
        }
        if (list.size() < level) {
            list.add(new ArrayList<>());
        }
        currentLevel(node.left, level + 1, list);
        currentLevel(node.right, level + 1, list);
        list.get(level - 1).add(node.val);
    }
}
