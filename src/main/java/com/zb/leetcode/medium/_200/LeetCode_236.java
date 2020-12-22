package com.zb.leetcode.medium._200;

import com.zb.leetcode.TreeNode;

import java.util.Stack;

/***
 * 236. 二叉树的最近公共祖先
 * @author once
 * @date 2020/12/22 22:17
 *
 */
public class LeetCode_236 {
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     *
     *
     *
     *  
     *
     * 示例 1:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * 示例 2:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     *  
     *
     * 说明:
     *
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉树中。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        return lowestCommonAncestor(stack, root, p, q);
    }

    public TreeNode lowestCommonAncestor(Stack<TreeNode> stack,TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }
        stack.push(node);
        if (node.val == p.val || node.val == q.val) {
            if (node.val == p.val) {
                p = q;
            }else {
                q = p;
            }
            while (true) {
                node = stack.pop();
                if (isChildNode(node.left, p, q)) {
                    return node;
                }
                if (isChildNode(node.right, p, q)) {
                    return node;
                }
            }
        }
        TreeNode leftNode = lowestCommonAncestor(stack, node.left, p, q);
        if (leftNode == null) {
            return lowestCommonAncestor(stack, node.right, p, q);
        }
        return leftNode;
    }

    private boolean isChildNode(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        if (node.val == p.val || node.val == q.val) {
            return true;
        }
        return isChildNode(node.left,p,q) || isChildNode(node.right,p,q);
    }
}
