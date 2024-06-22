package com.adolfoeloy.dp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BuyAndSellStocksTest {
    private final BuyAndSellStocks bs = new BuyAndSellStocks();

    @Test
    void test1() {
        int[] input = new int[]{7, 1, 5, 3, 6, 4};
        int output = 5;

        assertThat(bs.maxProfit(input)).isEqualTo(output);
    }

    @Test
    void test2() {
        int[] input = new int[]{7, 6, 4, 3, 1};
        int output = 0;

        assertThat(bs.maxProfit(input)).isEqualTo(output);
    }

    @Test
    void test3() {
        int[] input = new int[]{2, 4, 1};
        int output = 2;

        assertThat(bs.maxProfit(input)).isEqualTo(output);
    }

}
