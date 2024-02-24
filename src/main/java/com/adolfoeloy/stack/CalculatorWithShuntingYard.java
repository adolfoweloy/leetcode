package com.adolfoeloy.stack;

import java.util.*;

/**
 * This calculator uses the shunting-yard algorithm to parse an arithmetic expression with many levels of precedence.
 * It's based on Dijkstra's shunting-yard algorithm to transform an expression written with infix notation into RPN.
 * RPN = Reverse polish notation.
 * Having an RPN representation, it makes it easy to use a stack to do the math with components stored in an output queue.
 */
public class CalculatorWithShuntingYard {
    private final static Map<String, Integer> opsMap = Map.of(
                "+", 1,
                "-", 1,
                "*", 2,
                "/", 2,
                "^", 2
            );
    public int calculate(String input) {
        var tokens = extractTokens(input.replaceAll(" ", ""));

        // shunting-yard algorithm
        var opsStack = new Stack<String>();
        var output = new LinkedList<String>();
        for (var token : tokens) {
            if (opsMap.containsKey(token)) {
                while (!opsStack.isEmpty()
                    && opsMap.get(token) <= opsMap.get(opsStack.peek())) {
                    output.addLast(opsStack.pop());
                }
                opsStack.push(token);
            } else {
                output.addLast(token);
            }
        }
        while (!opsStack.isEmpty()) output.addLast(opsStack.pop());

        // now I can use a stack to do the math
        var stack = new Stack<Integer>();
        while (!output.isEmpty()) {
            var token = output.poll();
            if (!opsMap.containsKey(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                var n1 = stack.pop();
                var n2 = stack.pop();
                stack.push(eval(token, n1, n2));
            }
        }

        return stack.pop();
    }

    private int eval(String op, int n1, int n2) {
        switch (op) {
            case "+": return n1 + n2;
            case "-": return n2 - n1;
            case "*": return n1 * n2;
            case "/": return n2 / n1;
            case "^": return (int) Math.pow(n1, n2);
            default: throw new UnsupportedOperationException("operation not supported");
        }
    }

    private List<String> extractTokens(String input) {
        var list = new ArrayList<String>();
        for (int i = 0; i < input.length(); i++) {
            var token = input.charAt(i);
            if (opsMap.containsKey(token + "")) {
                list.add(token + "");
            } else {
                // get the whole number
                var current = 0;
                while (Character.isDigit(token)) {
                    current = current * 10 + (token - '0');
                    i++;
                    if (i == input.length()) break;
                    if (opsMap.containsKey(input.charAt(i) + "")) break;
                    token = input.charAt(i);
                }
                list.add(Integer.toString(current));
                i--;
            }
        }
        return list;
    }

}
