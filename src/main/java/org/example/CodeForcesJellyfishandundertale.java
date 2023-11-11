package org.example;

import java.math.BigInteger;
import java.util.Scanner;

public class CodeForcesJellyfishandundertale {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            int[] x = new int[n];
            for(int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
            }
            ;
            System.out.printf("%s\n", solve(a, b, n, x).toString());

        }
    }

    private static BigInteger solve(int maxTime, int intialTime , int n, int[] tools) {
        BigInteger sum = new BigInteger(String.valueOf(intialTime -1));
        for (int i = 0; i < n; i++) {
            sum = sum.add(BigInteger.valueOf(Math.min(1 + tools[i], maxTime) - 1));
        }
         return sum.add(BigInteger.ONE);
    }
}
