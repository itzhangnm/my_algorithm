package com.zb.leetcode.sword;

import com.zb.leetcode.ListNode;

import java.util.Stack;

/***
 * 剑指 Offer 06. 从尾到头打印链表
 * @author once
 * @date 2020/11/30 22:04
 *
 */
public class Sword_06 {
    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     *  
     * <p>
     * 限制：
     * <p>
     * 0 <= 链表长度 <= 10000
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] reversePrint(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

}
