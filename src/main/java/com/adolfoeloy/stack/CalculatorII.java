package com.adolfoeloy.stack;

import java.util.Stack;

public class CalculatorII {
    public int calculate(String input) {
        var stack = new Stack<Integer>();
        var formattedInput = input.replaceAll(" ", "");
        var currentNumber = 0;
        var operator = '+';

        for (int i = 0; i < formattedInput.length(); i++) {
            char c = formattedInput.charAt(i);

            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }

            if (!Character.isDigit(c) || i == formattedInput.length() - 1) {
                if (operator == '+') stack.push(currentNumber);
                if (operator == '-') stack.push(-currentNumber);
                if (operator == '*') stack.push(stack.pop() * currentNumber);
                if (operator == '/') stack.push(stack.pop() / currentNumber);
                currentNumber = 0;
                operator = c;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
