package com.zb.leetcode.medium._000;

import com.zb.leetcode.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 * @author Zhang Bo
 * @date 2020/9/15 11:19
 */
public class LeetCode_019 {

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

     示例：

     给定一个链表: 1->2->3->4->5, 和 n = 2.

     当删除了倒数第二个节点后，链表变为 1->2->3->5.
     说明：

     给定的 n 保证是有效的。

     进阶：

     你能尝试使用一趟扫描实现吗？

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        LeetCode_019 leetCode019 = new LeetCode_019();
        ListNode newNode = leetCode019.removeNthFromEnd(node, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(1);
        result.next = head;
        ListNode longTemp = result;
        ListNode smallTemp = result;
        while (n > 0) {
            longTemp = longTemp.next;
            n--;
        }
        while (longTemp.next != null) {
            longTemp = longTemp.next;
            smallTemp = smallTemp.next;
        }
        smallTemp.next = smallTemp.next.next;
        return result.next;
    }
}
