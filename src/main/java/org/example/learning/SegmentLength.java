package org.example.learning;

import java.util.Scanner;

public class SegmentLength {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long s = sc.nextLong();
        int[] a= readArray(sc, n);
        // 2 6 4 3 6 8 9
        long ss = 0;
        int l = 0;
        long ans = 0;
        for (int r = 0; r < a.length; r++) {
            ss += a[r];
            while(ss > s) {
                ss -= a[l];
                l++;
            }
            int len = r -l + 1;
//            ans += (len *(len + 1)) >> 1;
            ans += ((long)len *((long)len + 1)) >> 1;
        }
        System.out.printf("%d", ans);
    }

    private static int[]  readArray(Scanner sc, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        return a;
    }
}
