package com.adolfoeloy.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorWithShuntingYardTest {

    private CalculatorWithShuntingYard subject;

    @BeforeEach
    void setUp() {
        subject = new CalculatorWithShuntingYard();
    }

    @Test
    void should_return_the_number_when_only_one_number_is_provided() {
        assertThat(subject.calculate("42")).isEqualTo(42);
    }
    @Test
    void should_return_the_sum_between_two_elements() {
        assertThat(subject.calculate("1 + 1")).isEqualTo(2);
    }

    @Test
    void should_return_the_sum_between_two_elements_when_there_is_no_space_between_operator_and_operands() {
        assertThat(subject.calculate("1+1")).isEqualTo(2);
    }

    @Test
    void should_return_the_sum_between_two_elements_with_two_digits() {
        assertThat(subject.calculate("10+25")).isEqualTo(35);
    }

    @Test
    void should_return_the_subtraction_between_two_elements() {
        assertThat(subject.calculate("1 - 1")).isEqualTo(0);
    }

    @Test
    void should_return_negative_number_from_the_subtraction_operation() {
        assertThat(subject.calculate("1 - 2")).isEqualTo(-1);
    }

    @Test
    void should_return_positive_number_from_the_subtraction_operation() {
        assertThat(subject.calculate("2 - 1")).isEqualTo(1);
    }

    @Test
    void should_return_the_result_of_a_simple_multiplication() {
        assertThat(subject.calculate("7 * 6")).isEqualTo(42);
    }

    @Test
    void should_return_the_result_of_a_simple_division_with_rounded_up_value() {
        assertThat(subject.calculate("7 / 6")).isEqualTo(1);
    }

    @Test
    void should_return_the_result_of_a_simple_division() {
        assertThat(subject.calculate("100 / 4")).isEqualTo(25);
    }

    @Test
    void should_return_the_right_value_when_there_is_addition_and_subtraction() {
        assertThat(subject.calculate("2 + 5 - 10")).isEqualTo(-3);
    }

    @Test
    void should_return_the_right_value_when_there_is_addition_and_multiplication() {
        assertThat(subject.calculate("2 * 5 - 10")).isEqualTo(0);
    }

    @Test
    void should_pass_first_case_from_leetcode() {
        assertThat(subject.calculate("3+2*2")).isEqualTo(7);
    }

    @Test
    void should_return_the_right_value_when_there_is_addition_and_multiplication_with_precedence() {
        assertThat(subject.calculate("2 + 5 * 10")).isEqualTo(52);
    }

    @Test
    void should_return_the_right_value_when_there_are_many_operations() {
        assertThat(subject.calculate("2 + 5 * 10 / 2")).isEqualTo(27);
    }

    @Test
    void corner_case() {
        var result = subject.calculate("1-1+1");
        assertThat(result).isEqualTo(1);

    }
}
