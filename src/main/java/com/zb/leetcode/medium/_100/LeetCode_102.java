package com.zb.leetcode.medium._100;

import com.zb.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * @author Zhang Bo
 * @date 2020/11/13 18:16
 */
public class LeetCode_102 {

    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

      

     示例：
     二叉树：[3,9,20,null,null,15,7],

     3
     / \
     9  20
     /  \
     15   7
     返回其层次遍历结果：

     [
     [3],
     [9,20],
     [15,7]
     ]

     来源：力扣（LeetCode_148）
     链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelNode(result, 0, root);
        return result;
    }

    private void levelNode(List<List<Integer>> result, int curLevel, TreeNode node) {
        if (node != null) {
            if (result.size() == curLevel) {
                result.add(new ArrayList<>());
            }
            result.get(curLevel).add(node.val);
            levelNode(result,curLevel+1,node.left);
            levelNode(result,curLevel+1,node.right);
        }
    }
}
