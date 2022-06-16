package org.example;

import java.util.stream.Stream;

public class StringCalculator {

    public int Add(String numbers) {

        if (!numbers.isEmpty()) {
            int[] numArray = Stream.of(numbers.split(",")).mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            for (int i = 0; i < numArray.length; i++) {
                sum += numArray[i];
            }
            return sum;
        }
        return 0;
    }
}
