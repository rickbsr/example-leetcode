package com.rick.problems;

import com.rick.common.ListNode;

public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode res = new MiddleOfTheLinkedList().middleNode(head);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public ListNode middleNode(ListNode head) {
        int count = countNodes(head) / 2;
        for (; count > 0; count--) head = head.next;
        return head;
    }

    private int countNodes(ListNode head) {
        int count = 0;
        for (; head != null; count++) head = head.next;
        return count;
    }
}
