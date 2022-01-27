package day04;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class PairFinder {

    public long findPairs(List<Integer> numbers) {
        return numbers.stream()
                .collect(groupingBy(
                        o -> o,
                        counting()))
                .values().stream()
                .mapToLong(count -> count / 2)
                .sum();
    }

    public int findPairs(int[] arr) {
        int[] counts = new int[10];
        for (int i : arr) {
            counts[i]++;
        }

        int result = 0;
        for (int i = 0; i < counts.length; i++) {
            result += counts[i] / 2;
        }
        return result;
    }

}
