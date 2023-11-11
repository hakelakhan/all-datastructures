package org.example;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class CodeForcesChipsOnBoard {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--  > 0) {
             int n = sc.nextInt();
             int[] a = new int[n];
             int[] b = new int[n];
             for(int i = 0; i < n; i++) {
                 a[i] = sc.nextInt();
             }
            for(int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            var ans = findCost(a, b, n);
            System.out.printf("%s\n" ,ans.toString());
        }
    }

    private static BigInteger findCost(int[] a, int[] b, int n) {
        BigInteger sumCols = Arrays.stream(b).mapToObj(x -> new BigInteger(x + "")).reduce(BigInteger::add).orElse(BigInteger.ONE);
        var sumRows = Arrays.stream(a).mapToObj(x -> new BigInteger(x + "")).reduce(BigInteger::add).orElse(BigInteger.ONE);
        var minCol = new BigInteger(String.valueOf(Arrays.stream(b).min().getAsInt()));
        var minRow = new BigInteger(String.valueOf(Arrays.stream(a).min().getAsInt()));
        BigInteger nb = new BigInteger(String.valueOf(n));

        var min1 = nb.multiply(minRow).add( sumCols);
        var min2 = nb.multiply(minCol).add(sumRows);
        /*

         n * minRow + sumCols;       n * minCol + sumRows;
         */
        return min1.compareTo(min2) > 0 ? min2 : min1;
    }
}
