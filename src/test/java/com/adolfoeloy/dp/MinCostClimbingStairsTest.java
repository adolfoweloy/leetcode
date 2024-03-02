package com.adolfoeloy.dp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MinCostClimbingStairsTest {

    @Test
    void test1() {
        var subject = new MinCostClimbingStairs();
        var result = subject.minCostClimbingStairs(new int[] {10,15,20});
        Assertions.assertThat(result).isEqualTo(15);
    }

    @Test
    void test2() {
        var subject = new MinCostClimbingStairs();
        var result = subject.minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1});
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void test3() {
        var subject = new MinCostClimbingStairs();
        var result = subject.minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1});
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void test4() {
        var subject = new MinCostClimbingStairs();
        var result = subject.minCostClimbingStairs(new int[] {1,100});
        Assertions.assertThat(result).isEqualTo(1);
    }
}