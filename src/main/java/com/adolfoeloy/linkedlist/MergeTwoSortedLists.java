package com.adolfoeloy.linkedlist;

import com.adolfoeloy.common.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-999);
        ListNode p = head;

        ListNode h1 = list1;
        ListNode h2 = list2;

        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                p.next = new ListNode(h1.val);
                h1 = h1.next;
            } else {
                p.next = new ListNode(h2.val);
                h2 = h2.next;
            }
            p = p.next;
        }

        while (h1 != null) {
            p.next = new ListNode(h1.val);
            p = p.next;
            h1 = h1.next;
        }

        while (h2 != null) {
            p.next = new ListNode(h2.val);
            p = p.next;
            h2 = h2.next;
        }

        return head.next;

    }

}
