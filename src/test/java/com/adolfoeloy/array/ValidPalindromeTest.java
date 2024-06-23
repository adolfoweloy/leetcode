package com.adolfoeloy.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidPalindromeTest {
    private final ValidPalindrome subject = new ValidPalindrome();

    @Test
    void test1() {
        String input = "A man, a plan, a canal: Panama";

        assertThat(subject.isPalindrome(input)).isTrue();
    }

    @Test
    void test2() {
        String input = "race a car";

        assertThat(subject.isPalindrome(input)).isFalse();
    }

}