package org.example;

import java.util.stream.Stream;

public class StringCalculator {

    public int Add(String numbers) {
        if (!numbers.isEmpty()) {
        return Stream.of(numbers.split(",|\n")).mapToInt(Integer::parseInt).sum();
        }
        return 0;
    }
}
