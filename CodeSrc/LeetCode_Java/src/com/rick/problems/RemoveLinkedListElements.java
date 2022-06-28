package com.rick.problems;

import com.rick.common.ListNode;

public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next = new ListNode(0);
        ListNode res = new RemoveLinkedListElements().removeElements(head, 4);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null) {
            if (current.next.val == val)
                current.next = current.next.next;
            else current = current.next;
        }
        return dummy.next;
    }
}
