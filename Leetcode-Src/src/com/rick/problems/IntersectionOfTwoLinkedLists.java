package com.rick.problems;

import com.rick.common.ListNode;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(5);
        node.next.next = new ListNode(4);

        ListNode headA = new ListNode(0);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = node;

        ListNode headB = new ListNode(3);
        headB.next = new ListNode(3);
        headB.next.next = node;

        ListNode res = new IntersectionOfTwoLinkedLists().getIntersectionNode(headA, headB);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int lenDiff = getListNodeLength(headA) - getListNodeLength(headB);
        if (lenDiff < 0) return getIntersectionNode(headB, headA);

        ListNode copyA = headA, copyB = headB;
        while (--lenDiff >= 0) copyA = copyA.next;
        while (copyA != null && copyB != null) {
            if (copyA == copyB) return copyA;
            copyA = copyA.next;
            copyB = copyB.next;
        }
        return null;
    }

    private int getListNodeLength(ListNode node) {
        int len = 0;
        for (; node != null; len++) node = node.next;
        return len;
    }
}
