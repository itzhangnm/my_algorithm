package com.zb.leetcode.simple._500;

import com.zb.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 * @author Zhang Bo
 * @date 2020/10/26 17:05
 */
public class LeetCode_501 {
    /**
     * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

     假定 BST 有如下定义：

     结点左子树中所含结点的值小于等于当前结点的值
     结点右子树中所含结点的值大于等于当前结点的值
     左子树和右子树都是二叉搜索树
     例如：
     给定 BST [1,null,2,2],

     1
     \
     2
     /
     2
     返回[2].

     提示：如果众数超过1个，不需考虑输出顺序

     进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）

     来源：力扣（LeetCode_148）
     链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    private int count;
    private int maxCount;
    private int base;
    private List<Integer> answer = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        if (answer.size() > 0) {
            int[] result = new int[answer.size()];
            for (int i = 0; i < answer.size(); i++) {
                result[i] = answer.get(i);
            }
            return result;
        }
        return new int[]{};
    }


    

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        change(node.val);
        dfs(node.right);

    }

    private void change(int val) {
        if (val == base) {
            count++;
        }else{
            base = val;
            count = 1;
        }
        if (count == maxCount) {
            answer.add(val);
        }
        if (count > maxCount) {
            answer.clear();
            answer.add(val);
            maxCount = count;
        }
    }


}
