package org.example.learning;

import java.util.Scanner;

public class NoEquals2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] a= readArray(sc, m);
        int[] b= readArray(sc, n);
        printSum(a,b, m, n);

    }

    private static void printSum(int[] a, int[] b, int m, int n) {
        /* 1 1 3 3 3 5 8 8
           1 3 3 4 5 5 5   */
        int i = 0;
        int j = 0;
        int prev = -1;
        int ucnt = 0;
        int dcnt = 0;
        long sum = 0;
        boolean calc = false;
        while(i < m && j < n) {
            int current;
            boolean isUp = false;
            if(a[i] < b[j]) {
                current = a[i++];
                isUp = true;
            }
            else {// if(a[i] >= b[j] ) {
                current = b[j++] ;
            }
            if(current == prev) {
                if(isUp) {
                    ucnt++;
                }
                else {
                    dcnt++;
                }
                calc = false;
            }
            else {
                sum += ucnt*dcnt;
                calc = true;
                prev = current;
                ucnt = isUp ? 1 : 0;
                dcnt = !isUp ? 1 : 0;
            }


        }
        while(i < m) {
            int current = a[i++] ;
            if(current == prev) {
                ucnt++;
                calc = false;
            }
        }
        while(j < n) {
            int current = b[j++] ;
            if(current == prev) {
                dcnt++;
                calc = false;
            }

        }
        if(!calc) {
            sum += ucnt*dcnt;
        }

        System.out.printf("%d", sum);
    }

    private static int[]  readArray(Scanner sc, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        return a;
    }
}
