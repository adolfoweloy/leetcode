package com.adolfoeloy.stack;

import java.util.*;
import java.util.function.Consumer;

public class CalculatorII {
    private final static Map<Character, Integer> operators = Map.of(
            '+', 1,
            '-', 1,
            '*', 2,
            '/', 2,
            '^', 3
    );

    public int calculate(String input) {
        var operatorStack = new Stack<Token>();
        var outputQueue = new LinkedList<Token>();
        var stack = new Stack<Integer>();

        var tokens = getTokens(input);

        for (var token : tokens) {
            if (token.isOperator) {

                // move all operators with same or higher precedence to the output queue
                while (!operatorStack.isEmpty()
                        && operators.get(operatorStack.peek().operator) >= operators.get(token.operator)) {
                    outputQueue.addLast(operatorStack.pop());
                }

                // lately push the current operator to the operator stack
                operatorStack.push(token);
            } else {
                outputQueue.addLast(token);
            }
        }

        // add the remaining operators to the output.
        while (!operatorStack.isEmpty()) {
            outputQueue.addLast(operatorStack.pop());
        }

        // calculate
        for (var token : outputQueue) {
            if (!token.isOperator) {
                stack.push(token.number);
            } else {
                var n1 = stack.pop();
                var n2 = stack.pop();
                stack.push(evaluate(token.operator, n1, n2));
            }
        }

        return stack.pop();
    }

    private Integer evaluate(char operator, int n1, int n2) {
        switch (operator) {
            case '+': return n1 + n2;
            case '-': return n2 - n1;
            case '*': return n1 * n2;
            case '/': return n2 / n1;
            case '^': return (int) Math.pow(n1, n2);
            default: throw new UnsupportedOperationException("Invalid operator");
        }
    }

    private static Tokens getTokens(String input) {
        var result = new Tokens();
        var fInput = input.replaceAll(" ", "");
        var number = 0;

        for (int i = 0; i < fInput.length(); i++) {
            char c = fInput.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else {
                result.add(new Token(number));
                result.add(new Token(c));
                number = 0;
            }
        }

        result.add(new Token(number));
        return result;
    }

    private static class Token {
        private Integer number;
        private Character operator;
        private boolean isOperator;
        Token(Integer number) {
            this.number = number;
        }
        Token(char operator) {
            this.operator = operator;
            isOperator = true;
        }
    }

    private static class Tokens implements Iterable<Token> {
        private final List<Token> tokens = new ArrayList<>();

        void add(Token token) {
            tokens.add(token);
        }

        @Override
        public Iterator<Token> iterator() {
            return tokens.iterator();
        }

        @Override
        public void forEach(Consumer<? super Token> action) {
            tokens.forEach(action);
        }

        @Override
        public Spliterator<Token> spliterator() {
            return tokens.spliterator();
        }
    }

    public static void main(String[] args) {
        var c = new CalculatorII();
        c.calculate("1 + 2 * 3");
    }
}
