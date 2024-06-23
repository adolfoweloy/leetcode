package com.adolfoeloy.array;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && isNotDigitOrLetter(s, left)) left++;
            while (left < right && isNotDigitOrLetter(s, right)) right--;

            if (differentChar(s, left, right)) return false;

            left++; right--;
        }

        return true;
    }

    private boolean differentChar(String s, int left, int right) {
        return Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right));
    }

    private static boolean isNotDigitOrLetter(String s, int index) {
        return !Character.isLetterOrDigit(Character.toLowerCase(s.charAt(index)));
    }

}
