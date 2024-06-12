package com.adolfoeloy.array;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    private static final Map<Character, Character> rules = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
    );

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (rules.containsKey(c)) {
                if (stack.isEmpty()) return false;
                char openingBracket = stack.pop();
                if (rules.get(c) != openingBracket) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
