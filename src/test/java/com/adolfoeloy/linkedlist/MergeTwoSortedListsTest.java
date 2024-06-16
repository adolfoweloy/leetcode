package com.adolfoeloy.linkedlist;

import com.adolfoeloy.common.ListNode;
import org.junit.jupiter.api.Test;

import static com.adolfoeloy.util.LeetcodeAssertions.assertThat;

class MergeTwoSortedListsTest {
    private MergeTwoSortedLists subject = new MergeTwoSortedLists();

    @Test
    void test1() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode expected = new ListNode(1,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(4))))));

        ListNode r = subject.mergeTwoLists(list1, list2);

        assertThat(r).isSameAs(expected);
    }

    @Test
    void test2() {
        ListNode list1 = null;
        ListNode list2 = null;
        ListNode expected = null;

        ListNode r = subject.mergeTwoLists(list1, list2);

        assertThat(r).isSameAs(expected);
    }

    @Test
    void test3() {
        ListNode list1 = null;
        ListNode list2 = new ListNode(0);
        ListNode expected = new ListNode(0);

        ListNode r = subject.mergeTwoLists(list1, list2);

        assertThat(r).isSameAs(expected);
    }

}