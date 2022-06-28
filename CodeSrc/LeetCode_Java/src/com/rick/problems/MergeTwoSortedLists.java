package com.rick.problems;

import com.rick.common.ListNode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(7);
        l1.next.next.next = new ListNode(8);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(5);
        ListNode res = new MergeTwoSortedLists().mergeTwoLists(l1, l2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1), temp = res;
        while (l1 != null && l2 != null)
            if (l1.val <= l2.val) {
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }
        if (l1 != null) temp.next = l1;
        if (l2 != null) temp.next = l2;
        return res.next;
    }
}
