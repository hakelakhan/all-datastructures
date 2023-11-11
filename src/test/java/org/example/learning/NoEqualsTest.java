package org.example.learning;

import org.example.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoEqualsTest {

    @Test
    void getSum() {
        int actual = NoEquals.getSum(2, 3, Utils.stringtoArray("1 1"), Utils.stringtoArray("1 1 1") );
        Assertions.assertEquals(6, actual);
    }
}