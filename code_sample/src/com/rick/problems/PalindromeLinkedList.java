package com.rick.problems;

import com.rick.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(-129);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next.next = new ListNode(-129);
        boolean res = new PalindromeLinkedList().isPalindrome(head);
        System.out.println(res);
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (; head != null; head = head.next) list.add(head.val);
        for (int i = 0, j = list.size() - 1; i <= j; i++, j--)
            if ((int) list.get(i) != list.get(j)) return false;
        return true;
    }
}
