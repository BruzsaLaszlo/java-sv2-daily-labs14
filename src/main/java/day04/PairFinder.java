package day04;

import java.util.List;

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

}
