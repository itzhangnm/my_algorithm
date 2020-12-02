package com.zb.leetcode.sword;

import com.zb.leetcode.TreeNode;

/***
 * 剑指 Offer 07. 重建二叉树
 * @author once
 * @date 2020/12/2 23:15
 *
 */
public class Sword_07 {
    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * <p>
     *  
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
     *  
     * <p>
     * 限制：
     * <p>
     * 0 <= 节点个数 <= 5000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        Sword_07 sword_07 = new Sword_07();
        sword_07.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(0, preorder, 0, inorder.length - 1, inorder);
    }

    private TreeNode buildTree(int rootIndex, int[] preorder, int start, int end, int[] inorder) {
        int rootVal = preorder[rootIndex];
        TreeNode root = new TreeNode(rootVal);
        int inorderRootIndex = start;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == rootVal) {
                break;
            }
            inorderRootIndex++;
        }
        int leftCount = inorderRootIndex - start;
        if (leftCount > 0) {
            root.left = buildTree(rootIndex + 1, preorder, start, inorderRootIndex - 1, inorder);
        }
        if (inorderRootIndex < end) {
            root.right = buildTree(rootIndex + leftCount + 1, preorder,inorderRootIndex + 1, end, inorder);
        }
        return root;
    }
}
