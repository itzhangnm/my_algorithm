package com.zb.leetcode.simple._000;

import com.zb.leetcode.ListNode;

/***
 *
 * 83.删除排序链表中的重复元素
 * @author once
 * @date 2019/12/1 11:23
 *
 */
public class LeetCode_083 {
    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1->1->2
     * 输出: 1->2
     * 示例 2:
     * <p>
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LeetCode_083 leetCode083 = new LeetCode_083();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        ListNode listNode = leetCode083.deleteDuplicates(l1);
        listNode.print(listNode);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(2);
        l2.next.next.next = new ListNode(3);
        l2.next.next.next.next = new ListNode(3);
        listNode = leetCode083.deleteDuplicates(l2);
        listNode.print(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                //相同，删除节点，指针不移动
                temp.next = temp.next.next;
            }else{
                //不同，指针后移
                temp = temp.next;
            }
        }
        return head;
    }
}
