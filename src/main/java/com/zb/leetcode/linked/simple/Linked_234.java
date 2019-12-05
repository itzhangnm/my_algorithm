package com.zb.leetcode.linked.simple;

import com.zb.leetcode.linked.ListNode;

/**
 * @author Zhang Bo
 * @date 2019/12/4 15:53
 */
public class Linked_234 {

    /**
     * 请判断一个链表是否为回文链表。

     示例 1:

     输入: 1->2
     输出: false
     示例 2:

     输入: 1->2->2->1
     输出: true
     */

    public static void main(String[] args) {
        Linked_234 linked_234 = new Linked_234();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next  = new ListNode(3);
        node.next.next.next.next  = new ListNode(2);
        node.next.next.next.next.next  = new ListNode(1);
        System.out.println(linked_234.isPalindrome(node));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode tmp;
        ListNode reverseHead = head;
        ListNode shortNode = head;
        ListNode longNode = head;
        while (longNode != null && longNode.next != null) {
            tmp = reverseHead;
            reverseHead = shortNode;
            shortNode = shortNode.next;
            longNode = longNode.next.next;
            reverseHead.next = tmp;
        }

        //奇数链表 后半段链表进一位对称
        if (longNode != null) {
            shortNode = shortNode.next;
        }

        //反转前半段链表与后半段依次比较
        while (shortNode != null) {
            if (shortNode.val != reverseHead.val) {
                return false;
            }
            shortNode = shortNode.next;
            reverseHead = reverseHead.next;
        }

        return true;
    }
}
