package day04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PairFinderTest {

    PairFinder pf = new PairFinder();

    @Test
    void findPairs() {
        var numbers = List.of(5, 1, 4, 5);
        assertEquals(1, pf.findPairs(numbers));

        numbers = List.of(7, 1, 5, 7, 3, 3, 5, 7, 6, 7);
        assertEquals(4, pf.findPairs(numbers));
    }

    @Test
    void findPairsArray() {
        int[] numbers = {5, 1, 4, 5};
        assertEquals(1, pf.findPairs(numbers));

        numbers = new int[]{7, 1, 5, 7, 3, 3, 5, 7, 6, 7};
        assertEquals(4, pf.findPairs(numbers));
    }
}