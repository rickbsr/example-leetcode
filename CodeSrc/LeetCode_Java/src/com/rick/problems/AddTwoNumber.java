package com.rick.problems;


import com.rick.common.ListNode;

public class AddTwoNumber {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = new AddTwoNumber().addTwoNumbers(l1, l2);
        while (true) {
            System.out.println(res.val);
            if (res.next != null) res = res.next;
            else break;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 建立一個假的節點，當作 head 使用
        ListNode dummy = new ListNode(0);

        ListNode cur = dummy; // 當前節點
        ListNode p = l1, q = l2;

        int sum = 0; // 總和，進位判斷

        // 如果兩個都不是 null -> 則必須運算
        while (p != null || q != null) {

            // 若 p 不是 null
            if (p != null) {
                sum += p.val;
                p = p.next; // 將 p 的節點往後移一位
            }
            // 這邊原理就同上
            if (q != null) {
                sum += q.val;
                q = q.next;
            }

            cur.next = new ListNode(sum % 10); // 計算出當前節點的數值
            cur = cur.next; // 節點移動一位

            sum /= 10; // 若 sum > 10 代表有進位，保留為 1，若 sum < 10 則將它歸 0
        }

        // 這時候代表 p & q 都是 null，此時要判斷 sum 若等於 1，則代表上一位的運算有進位，補上 1
        if (sum == 1) cur.next = new ListNode(1);

        // 因為第一個是假節點，因此返回 dummy.next
        return dummy.next;
    }
}
