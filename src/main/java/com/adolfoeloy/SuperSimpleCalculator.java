package com.adolfoeloy;

import java.util.regex.Pattern;

public class SuperSimpleCalculator {

    public int eval(String input) {
        Pattern pattern = Pattern.compile("\\d+");
        return pattern.matcher(input)
                .results()
                .map(match -> Integer.valueOf(match.group()))
                .reduce(0, Integer::sum);
    }

}
