package org.example;

import java.util.stream.Stream;

public class StringCalculator {

    public int Add(String numbers) {

        if (numbers.startsWith("//")) {
            char delimiter = numbers.charAt(2);
            return Stream.of(numbers.substring(4).split(String.valueOf(delimiter))).mapToInt(Integer::parseInt).sum();
        }
        if(!numbers.isEmpty()){
            return Stream.of(numbers.split(",|\n")).mapToInt(Integer::parseInt).sum();
        }

        return 0;
    }
}
