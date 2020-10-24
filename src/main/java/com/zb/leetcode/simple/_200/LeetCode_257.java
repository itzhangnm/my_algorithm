package com.zb.leetcode.simple._200;

import com.zb.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/***
 * 257. 二叉树的所有路径
 * @author once
 * @date 2020/10/24 17:00
 *
 */
public class LeetCode_257 {
    /**
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     *
     * 输入:
     *
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     *
     * 输出: ["1->2->5", "1->3"]
     *
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-paths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        addTreePaths(root, list, "");
        return list;
    }

    void addTreePaths(TreeNode node, List<String> list, String s) {
        if (node == null) {
            return;
        }
        if (s.equals("")) {
            s += node.val;
        }else {
            s = s + "->" + node.val;
        }
        if (node.left == null && node.right == null) {
            list.add(s);
        }else{
            addTreePaths(node.left,list,s);
            addTreePaths(node.right,list,s);
        }
    }
}
