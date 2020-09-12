package com.zb.leetcode.medium._000;

import com.zb.leetcode.ListNode;

/**
 * 2. 两数相加
 *
 * @author Zhang Bo
 * @date 2020/2/23 12:08
 */
public class LeetCode_002 {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);
        l2.next.next.next = new ListNode(9);
        LeetCode_002 leetCode002 = new LeetCode_002();
        ListNode r = leetCode002.addTwoNumbers(l1, l2);
        System.out.println(r);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r = new ListNode(0);
        ListNode tmpNode = r;
        tmpNode.next = new ListNode(0);
        while (l1 != null && l2 != null) {
            tmpNode = tmpNode.next;
            int tmp = l1.val + l2.val + tmpNode.val;
            tmpNode.val = tmp % 10;
            tmpNode.next = new ListNode(tmp / 10);
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode surplusNode = null;
        if (l1 == null) {
            surplusNode = l2;
        }else{
            surplusNode = l1;
        }
        while (surplusNode != null) {
            tmpNode = tmpNode.next;
            int tmp = surplusNode.val + tmpNode.val;
            tmpNode.val = tmp % 10;
            tmpNode.next = new ListNode(tmp / 10);
            surplusNode = surplusNode.next;
        }
        if (tmpNode.next.val == 0) {
            tmpNode.next = null;
        }
        return r.next;
    }
}
