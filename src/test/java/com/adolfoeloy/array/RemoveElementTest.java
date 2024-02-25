package com.adolfoeloy.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveElementTest {

    @Test
    void should_remove_elements() {
        var subject = new RemoveElement();
        var n = new int[] {3,2,2,3};
        var k = subject.removeElement(n, 3);
        assertThat(k).isEqualTo(2);
        assertThat(Arrays.copyOf(n, k)).containsExactly(2, 2);
    }

}