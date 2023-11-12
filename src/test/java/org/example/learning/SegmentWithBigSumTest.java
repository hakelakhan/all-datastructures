package org.example.learning;

import org.example.Utils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SegmentWithBigSumTest {
    public SegmentWithBigSumTest() {

    }
    @ParameterizedTest
    @CsvSource({
            "2 6 4 3 6 8 9, 20, 3",
            "4 5 6 5 2 5 1 5, 2000, -1",
            "85 85 85 85 85, 40, 1",
            "1 1 1 1, 4, 4"

    })
    public void a(String input, long s, long expected) {
        long actual = SegmentWithBigSum.findShortestSegWithSumAtMost(Utils.stringtoArray(input), s);
        assertEquals(expected, actual);

    }

}