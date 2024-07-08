package com.adolfoeloy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SuperSimpleCalculatorTest {

    private final SuperSimpleCalculator underTest = new SuperSimpleCalculator();

    @Test
    void eval__should_solve_simple_sum_with_single_digits_operands() {
        assertThat(underTest.eval("1+1"))
                .isEqualTo(2);
    }

    @Test
    void eval__should_sum_three_single_digit_numbers() {
        assertThat(underTest.eval("1+1+1"))
                .isEqualTo(3);
    }

    @Test
    void eval__should_sum_numbers_with_multiple_digits() {
        assertThat(underTest.eval("100+10+1"))
                .isEqualTo(111);
    }
}