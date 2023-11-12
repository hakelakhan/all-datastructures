package org.example.learning;

import org.example.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NoOfSegmentswithBigSumTest {

    @ParameterizedTest
    @CsvSource({
            "2 6 4 3 6 8 9, 20, 9",
            "100000000 100000000, 1000000000, 3",
            "3 3, 3, 3"

    })
    void findAns(String input, long s, String expected) {
        String actual = NoOfSegmentswithBigSum.findAns(Utils.stringtoArray(input), s).toString();
        Assertions.assertEquals(expected, actual);


    }
}