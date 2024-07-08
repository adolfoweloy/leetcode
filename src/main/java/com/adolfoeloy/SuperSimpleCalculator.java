package com.adolfoeloy;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SuperSimpleCalculator {

    public int eval(String input) {
        Pattern numberPattern = Pattern.compile("\\d+");
        Pattern operatorPattern = Pattern.compile("[+-]");

        List<Integer> numbers = getNumbers(input, numberPattern);
        List<Character> operators = getOperators(input, operatorPattern);

        int result = numbers.remove(0);
        while (!numbers.isEmpty()) {
            int number = numbers.remove(0);
            char operator = operators.remove(0);

            switch (operator) {
                case '+':
                    result += number;
                    break;
                case '-':
                    result -= number;
                    break;
                default:
                    throw new IllegalArgumentException("Input contains invalid operator");
            }
        }
        return result;
    }


    private static List<Character> getOperators(String input, Pattern operatorPattern) {
        return operatorPattern.matcher(input)
                .results()
                .map(match -> match.group().charAt(0))
                .collect(Collectors.toList());
    }

    private static List<Integer> getNumbers(String input, Pattern numberPattern) {
        return numberPattern.matcher(input)
                .results()
                .map(match -> Integer.valueOf(match.group()))
                .collect(Collectors.toList());
    }

}
