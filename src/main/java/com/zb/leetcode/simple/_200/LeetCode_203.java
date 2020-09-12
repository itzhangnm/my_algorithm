package com.zb.leetcode.simple._200;

import com.zb.leetcode.ListNode;

/***
 *
 * 203.移除链表元素
 * @author once
 * @date 2019/12/1 15:11
 *
 */
public class LeetCode_203 {

    /**
     * 删除链表中等于给定值 val 的所有节点。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     */

    public ListNode removeElements(ListNode head, int val) {
        //增加一个哨兵节点
        ListNode sentinel = new ListNode(0);
        ListNode temp = sentinel;
        while (head != null) {
            if (head.val != val) {
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
        }
        //排除最后节点是目标删除节点
        temp.next = null;
        return sentinel.next;
    }
}
