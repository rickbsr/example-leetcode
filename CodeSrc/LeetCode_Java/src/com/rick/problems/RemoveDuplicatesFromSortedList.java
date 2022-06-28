package com.rick.problems;

import com.rick.common.ListNode;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next = new ListNode(4);
        ListNode res = new RemoveDuplicatesFromSortedList().deleteDuplicates(head);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        for (ListNode p = head, q = head.next; q != null; q = q.next)
            if (q.val == p.val) p.next = q.next;
            else p = p.next;
        return head;
    }
}
