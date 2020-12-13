package com.zb.leetcode.simple._100;


import com.zb.leetcode.TreeNode;

/**
 * 104. 二叉树的最大深度
 *
 * @author Zhang Bo
 * @date 2020/6/2 11:05
 */
public class LeetCode_104 {

    /**
     * 给定一个二叉树，找出其最大深度。
     * <p>
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_104 leetCode101 = new LeetCode_104();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(3);
        System.out.println(leetCode101.maxDepth(root));
        root.left.left = null;
        root.right.right.right = null;
        System.out.println(leetCode101.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = maxCount(root.left, 1);
        int rightCount = maxCount(root.right, 1);
        return leftCount > rightCount ? leftCount : rightCount;
    }

    public int maxCount(TreeNode node, int count) {
        if (node == null) {
            return count;
        }
        int leftCount = maxCount(node.left, count +1);
        int rightCount = maxCount(node.right, count + 1);
        return leftCount > rightCount ? leftCount : rightCount;
    }
}
