package org.example.learning;

import org.example.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DateProblemTest {

    @ParameterizedTest
    @CsvSource({
            "1 3 5 8, 4, 2",
            "1 3 5 8, 3, 3",
            "1 1 1 1 1, 2, 0"

    })
    /*
            1   3    5  8
            1 5 1 8
            3 8

     */
    void solve(String input, int distance, long output) {
        Assertions.assertEquals(output, DateProblem.solve(Utils.stringtoArray(input), distance));

    }
}