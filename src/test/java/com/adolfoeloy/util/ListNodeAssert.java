package com.adolfoeloy.util;

import com.adolfoeloy.common.ListNode;
import org.assertj.core.api.AbstractAssert;

public class ListNodeAssert extends AbstractAssert<ListNodeAssert, ListNode> {
    protected ListNodeAssert(ListNode actual, Class<?> selfType) {
        super(actual, selfType);
    }

    public void isSameAs(ListNode other) {
        ListNode actualPointer = actual;
        while (actualPointer != null && other != null) {
            if (actualPointer.val != other.val) {
                failWithMessage("Lists are different. Found: [%s]", actual.toString());
            }
            actualPointer = actualPointer.next;
            other = other.next;
        }
        if (!(actualPointer == null && other == null)) {
            failWithMessage("Lists are different. Found: [null]");
        }
    }
}
