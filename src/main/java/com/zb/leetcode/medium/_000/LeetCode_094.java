package com.zb.leetcode.medium._000;

import com.zb.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * @author Zhang Bo
 * @date 2020/11/13 17:18
 */
public class LeetCode_094 {

    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        inorderTraversal(root,result);
//        return result;

        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        TreeNode morrisRight;
        while (cur != null) {
            morrisRight = cur.left;
            if (morrisRight != null) {
                while (morrisRight.right != null && morrisRight.right != cur) {
                    morrisRight = morrisRight.right;
                }
                if (morrisRight.right == null) {
                    morrisRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    morrisRight.right = null;
                }

            }
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    public void inorderTraversal(TreeNode node,List<Integer> result) {
        if (node != null) {
            inorderTraversal(node.left, result);
            result.add(node.val);
            inorderTraversal(node.right, result);
        }
    }
}
