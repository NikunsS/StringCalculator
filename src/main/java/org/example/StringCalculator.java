package org.example;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = ",|\n";
    public static final int DELIMITER_POSITION = 2;
    public static final String METADATA_NUMBERS_SEPARATOR = "\n";
    public static final String CUSTOM_DELIMITER_PREFIX = "//";

    public int Add(String numbers) {
        String delimiter = DEFAULT_DELIMITER;

        if (numbers.isBlank()){
            return 0;
        }

        if (numbers.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            delimiter = String.valueOf(numbers.charAt(DELIMITER_POSITION));
            numbers = numbers.substring(numbers.indexOf(METADATA_NUMBERS_SEPARATOR)+1);
        }

        List<Integer> numberList = getNumbers(numbers, delimiter);
        determineNegativeNumbers(numberList);

        return numberList.stream()
                .reduce(0, Integer::sum);
    }

    private List<Integer> getNumbers(String numbers, String delimiter) {
        return Stream.of(numbers.split(delimiter))
                .map(Integer::valueOf)
                .collect(toList());
    }
    private void determineNegativeNumbers(List<Integer> numbers) throws IllegalArgumentException {
        List<Integer> negatives = numbers.stream()
                .filter(n -> n < 0)
                .collect(toList());

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives);
        }
    }
}
