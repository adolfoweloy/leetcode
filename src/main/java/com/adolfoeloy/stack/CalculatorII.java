package com.adolfoeloy.stack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CalculatorII {

    private final Map<Character, Integer> precedence = new HashMap<>();

    public int calculate(String input) {
        var numbers = new Stack<Integer>();
        var operators = new Stack<Character>();
        var formattedInput = input.replaceAll(" ", "");
        var factor = 1;

        for (int i = 0; i < formattedInput.length(); i++) {
            char c = formattedInput.charAt(i);

            // build values
            if (isOperator(c)) {
                operators.push(c);
                factor = (c == '-') ? -1 : 1;
            } else {
                var numBuilder = new StringBuilder();
                for (int j = i; j < formattedInput.length(); j++, ++i) {
                    if (isOperator(formattedInput.charAt(j))) {
                        break;
                    }
                    numBuilder.append(formattedInput.charAt(j));
                }
                i--;
                numbers.push(factor * Integer.parseInt(numBuilder.toString()));

                if (!operators.isEmpty() && precedence.get(operators.peek()) == 2) {
                    var right = numbers.pop();
                    var left = numbers.pop();
                    numbers.push(
                            apply(
                                    operators.pop(),
                                    left,
                                    right)
                    );
                }
            }

        }

        while (!operators.isEmpty()) {
            var operator = operators.pop();
            var right = numbers.pop();
            var left = numbers.pop();

            numbers.push(
                    apply(
                            operator,
                            left,
                            right)
            );
        }

        return numbers.pop();
    }

    CalculatorII() {
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
    }

    private boolean isOperator(char token) {
        return List.of('+', '-', '*', '/').contains(token);
    }

    private int apply(Character operator, int a, int b) {
        switch(operator) {
            case '+':
            case '-':
                return a + b;
            case '*': return a * b;
            case '/': return a / b;
            default:
                throw new UnsupportedOperationException(operator + " is not supported.");
        }
    }
}
