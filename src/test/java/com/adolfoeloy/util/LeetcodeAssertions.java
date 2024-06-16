package com.adolfoeloy.util;

import com.adolfoeloy.common.ListNode;

public class LeetcodeAssertions {
    public static ListNodeAssert assertThat(ListNode listNode) {
        return new ListNodeAssert(listNode, ListNodeAssert.class);
    }
}
