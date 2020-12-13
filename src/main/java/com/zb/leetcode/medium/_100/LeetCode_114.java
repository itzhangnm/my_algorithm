package com.zb.leetcode.medium._100;

import com.alibaba.fastjson.JSON;
import com.zb.leetcode.TreeNode;

/***
 * 114. 二叉树展开为链表
 * @author once
 * @date 2020/11/13 22:56
 *
 */
public class LeetCode_114 {

    /**
     * 给定一个二叉树，原地将它展开为一个单链表。
     * <p>
     *  
     * <p>
     * 例如，给定二叉树
     * <p>
     * 1
     * / \
     * 2   5
     * / \   \
     * 3   4   6
     * 将其展开为：
     * <p>
     * 1
     * \
     * 2
     * \
     * 3
     * \
     * 4
     * \
     * 5
     * \
     * 6
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        LeetCode_114 leetCode_114 = new LeetCode_114();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        leetCode_114.flatten(root);
        System.out.println(JSON.toJSONString(root));
        root = new TreeNode(1);
        leetCode_114.flatten(root);
        System.out.println(JSON.toJSONString(root));
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        leetCode_114.flatten(root);
        System.out.println(JSON.toJSONString(root));
    }

    public void flatten(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        TreeNode result = new TreeNode();
//        TreeNode tmp = result;
//        TreeNode cur = root;
//        TreeNode morrisNode;
//        while (cur != null) {
//            morrisNode = cur.left;
//            if (morrisNode != null) {
//                while (morrisNode.right != null && morrisNode.right != cur) {
//                    morrisNode = morrisNode.right;
//                }
//                if (morrisNode.right == null) {
//                    morrisNode.right = cur;
//                    tmp.right = new TreeNode(cur.val);
//                    tmp = tmp.right;
//                    cur = cur.left;
//                    continue;
//                } else {
//                    morrisNode.right = null;
//                }
//            } else {
//                tmp.right = new TreeNode(cur.val);
//                tmp = tmp.right;
//            }
//            cur = cur.right;
//        }
//        root.left = null;
//        root.right = result.right.right;
        //前驱节点查找优化
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }
}
