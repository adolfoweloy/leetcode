package com.adolfoeloy.array;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidParenthesesTest {
    private ValidParentheses subject = new ValidParentheses();

    @Nested
    class ExampleCases {
        @Test
        void test1() {
            String input = "()";
            boolean output = new ValidParentheses().isValid(input);
            assertThat(output).isTrue();

        }

        @Test
        void test2() {
            String input = "()[]{}";
            boolean output = new ValidParentheses().isValid(input);
            assertThat(output).isTrue();
        }

        @Test
        void test3() {
            String input = "(]";
            boolean output = new ValidParentheses().isValid(input);
            assertThat(output).isFalse();
        }
    }

    @Nested
    class CornerCases {
        @Test
        void cornerCase1() {
            String input = "[";
            boolean output = new ValidParentheses().isValid(input);
            assertThat(output).isFalse();
        }
    }

}