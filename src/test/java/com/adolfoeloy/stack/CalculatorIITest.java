package com.adolfoeloy.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorIITest {

    private CalculatorII subject;

    @BeforeEach
    void setUp() {
        subject = new CalculatorII();
    }

    @Test
    void should_return_the_sum_between_two_elements() {
        var result = subject.calculate("1 + 1");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void should_return_the_sum_between_two_elements_when_there_is_no_space_between_operator_and_operands() {
        var result = subject.calculate("1+1");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void should_return_the_sum_between_two_elements_with_two_digits() {
        var result = subject.calculate("10+25");
        assertThat(result).isEqualTo(35);
    }

    @Test
    void should_return_the_subtraction_between_two_elements() {
        var result = subject.calculate("1 - 1");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void should_return_negative_number_from_the_subtraction_operation() {
        var result = subject.calculate("1 - 2");
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void should_return_positive_number_from_the_subtraction_operation() {
        var result = subject.calculate("2 - 1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void should_return_the_result_of_a_simple_multiplication() {
        var result = subject.calculate("7 * 6");
        assertThat(result).isEqualTo(42);
    }

    @Test
    void should_return_the_result_of_a_simple_division_with_rounded_up_value() {
        var result = subject.calculate("7 / 6");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void should_return_the_result_of_a_simple_division() {
        var result = subject.calculate("100 / 4");
        assertThat(result).isEqualTo(25);
    }

    @Test
    void should_return_the_right_value_when_there_is_addition_and_subtraction() {
        var result = subject.calculate("2 + 5 - 10");
        assertThat(result).isEqualTo(-3);
    }

    @Test
    void should_return_the_right_value_when_there_is_addition_and_multiplication() {
        var result = subject.calculate("2 * 5 - 10");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void should_return_the_right_value_when_there_is_addition_and_multiplication_with_precedence() {
        var result = subject.calculate("2 + 5 * 10");
        assertThat(result).isEqualTo(52);
    }

    @Test
    void should_return_the_right_value_when_there_are_many_operations() {
        var result = subject.calculate("2 + 5 * 10 / 2");
        assertThat(result).isEqualTo(27);
    }

    @Test
    void corner_case() {
        var result = subject.calculate("1-1+1");
        assertThat(result).isEqualTo(1);

    }
}
