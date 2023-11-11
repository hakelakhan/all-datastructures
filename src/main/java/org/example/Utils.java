package org.example;

import java.util.Arrays;

public class Utils {

    public static int[] stringtoArray(String string) {
        return Arrays.stream(string.split(" ")).mapToInt(Integer::parseInt).toArray() ;
    }
}
