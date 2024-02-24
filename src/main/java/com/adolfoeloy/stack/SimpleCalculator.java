package com.adolfoeloy.stack;

import java.util.*;

/**
 * This calculator takes an arithmetic expression as a string, parses the input and do the math.
 * The strategy used here seems to be good when there are just two levels of precedence.
 * I couldn't use this algorithm to solve expressions with three levels of precedence.
 * The operators accepted here are + - * / where * and / have higher precedence over + and -. If I had e.g. ^
 * that would introduce another level of precedence (the third one) and the exponential would have higher precedence overall.
 * The following algorithm is a simple algorithm that applies operators with higher precedence as it goes with the
 * parsing stage and later sum up all the entries in the stack.
 */
public class SimpleCalculator {

    public int calculate(String input) {
        if (input == null || input.isEmpty()) return 0;
        var s = input.replaceAll(" ", "");
        var len = s.length();
        var stack = new Stack<Integer>();
        var number = 0;
        var op = '+';

        for (int i = 0 ; i < len; i++) {
            var token = s.charAt(i);
            if (Character.isDigit(token)) {
                number = 0;
                while (true) {
                    number = number * 10 + (token - '0');
                    if (++i == len) break;
                    token = s.charAt(i);
                    if (!Character.isDigit(token)) break;
                }
            }

            // if the given token is an operator OR it's the last number in an expression
            if (!Character.isDigit(token) || i == s.length()) {
                if (op == '+') stack.push(number);
                else if (op == '-') stack.push(-number);
                else if (op == '*') stack.push(stack.pop() * number);
                else if (op == '/') stack.push(stack.pop() / number);

                op = token;
                number = 0;
            }
        }

        if (stack.isEmpty()) return number;

        int r = 0;
        while (!stack.isEmpty()) {
            r += stack.pop();
        }
        return r;
    }

}
