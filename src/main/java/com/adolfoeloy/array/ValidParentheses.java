package com.adolfoeloy.array;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    private static final List<Character> closingBrackets = List.of(')', '}', ']');
    private static final Map<Character, Character> rules = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
    );

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() < 2) return false;
        for (char c : s.toCharArray()) {
            if (closingBrackets.contains(c)) {
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
