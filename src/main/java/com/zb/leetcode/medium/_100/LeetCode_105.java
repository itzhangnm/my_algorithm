package com.zb.leetcode.medium._100;

import com.zb.leetcode.TreeNode;

import java.util.Stack;

/***
 * 105. 从前序与中序遍历序列构造二叉树
 * @author once
 * @date 2020/12/8 20:49
 *
 */
public class LeetCode_105 {
    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * <p>
     * 注意:
     * 你可以假设树中没有重复的元素。
     * <p>
     * 例如，给出
     * <p>
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1) {
            return null;
        }
//        return buildTree(0, preorder, 0, inorder.length - 1, inorder);

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            TreeNode cur = stack.peek();
            if (cur.val != inorder[inorderIndex]) {
                cur.left = new TreeNode(preorder[i]);
                stack.push(cur.left);
            }else{
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    cur = stack.pop();
                    inorderIndex++;
                }
                cur.right = new TreeNode(preorder[i]);
                stack.push(cur.right);
            }
        }
        return root;

    }

//    private TreeNode buildTree(int rootIndex, int[] preorder, int leftStart, int leftEnd, int[] inorder) {
//        int curVal = preorder[rootIndex];
//        TreeNode root = new TreeNode(curVal);
//        int leftCount = 0;
//        for (int i = leftStart; i <= leftEnd; i++) {
//            if (inorder[i] == curVal) {
//                break;
//            }
//            leftCount++;
//        }
//        if (leftCount > 0) {
//            root.left = buildTree(rootIndex + 1, preorder, leftStart, leftStart + leftCount-1, inorder);
//        }
//        if (leftCount + leftStart < leftEnd) {
//            root.right = buildTree(rootIndex + leftCount + 1, preorder, rootIndex + leftStart + 1, leftEnd, inorder);
//        }
//        return root;
//    }
}
