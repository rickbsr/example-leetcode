package com.rick.problems;

import com.rick.common.ListNode;

public class DeleteNodeInALinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        ListNode node = head.next;
        new DeleteNodeInALinkedList().deleteNode(node);
        while (head != null) {
            System.out.print(head.val + "");
            head = head.next;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
