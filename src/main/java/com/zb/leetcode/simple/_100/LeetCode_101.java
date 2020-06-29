package com.zb.leetcode.simple._100;


import com.zb.leetcode.TreeNode;

/**
 * 101. 对称二叉树
 *
 * @author Zhang Bo
 * @date 2020/6/2 11:05
 */
public class LeetCode_101 {

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。

      

     例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

     1
     / \
     2   2
     / \ / \
     3  4 4  3
      

     但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

     1
     / \
     2   2
     \   \
     3    3
      

     进阶：

     你可以运用递归和迭代两种方法解决这个问题吗？

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/symmetric-tree
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_101 leetCode101 = new LeetCode_101();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(leetCode101.isSymmetric(root));
        root.left.left = null;
        System.out.println(leetCode101.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        return left == null && right == null || !(left == null || right == null) && left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
