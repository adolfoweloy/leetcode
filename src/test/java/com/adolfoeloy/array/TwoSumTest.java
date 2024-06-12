package com.adolfoeloy.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSumTest {

    @Test
    void test1() {
        TwoSum underTest = new TwoSum();

        int[] result = underTest.twoSum(new int[] { 2,7,11,15 }, 9);

        assertThat(result).containsExactlyInAnyOrder(0,1);
    }

    @Test
    void test2() {
        TwoSum underTest = new TwoSum();

        int[] result = underTest.twoSum(new int[] { 3,2,4 }, 6);

        assertThat(result).containsExactlyInAnyOrder(1,2);
    }

    @Test
    void test3() {
        TwoSum underTest = new TwoSum();

        int[] result = underTest.twoSum(new int[] { 3,3 }, 6);

        assertThat(result).containsExactlyInAnyOrder(0,1);
    }
}
