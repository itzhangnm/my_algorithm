package com.zb.leetcode;

import lombok.Data;

/***
 *
 * @author once
 * @date 2019/12/1 11:10
 *
 */
@Data
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void print(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
