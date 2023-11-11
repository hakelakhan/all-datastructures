package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Problem2Test {

    @Test
    void getNextSmaller() {
        int[] a = {808, 34, 134, 12, 1, 9, 43, 123, 314, 45};
        int[] ns = Problem2.getNextSmaller(a);
        System.out.printf("%s\n", Arrays.toString(a));
        System.out.printf("%s\n", Arrays.toString(ns));
    }
}