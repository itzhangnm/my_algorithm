package com.zb.leetcode.simple._200;

import com.zb.leetcode.ListNode;

/***
 * 206.反转链表
 * @author once
 * @date 2019/12/1 15:37
 *
 */
public class LeetCode_206 {

    /**
     * 反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public ListNode reverseList(ListNode head) {
        ListNode reverseHead= null;
        //临时指针记录反转头节点
        ListNode temp = null;
        while (head != null) {
            //更新反转头
            reverseHead = head;
            //移动原头
            head = head.next;
            //新头指向原临时头
            reverseHead.next = temp;
            //更新临时头指针
            temp = reverseHead;
        }
        return reverseHead;
    }

    public ListNode recursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverseNode = recursive(head.next);
        //next.next 其实就是head.next的下一个指针指向自己，就是反转了
        head.next.next = head;
        head.next = null;
        return reverseNode;
    }
}
