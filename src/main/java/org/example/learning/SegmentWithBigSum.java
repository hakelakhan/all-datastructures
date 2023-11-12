package org.example.learning;

import java.math.BigInteger;
import java.util.Scanner;

public class SegmentWithBigSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long s = sc.nextLong();
        int[] a = readArray(sc, n);

        int ans = findShortestSegWithSumAtMost(a, s);
        System.out.printf("%d", ans);

    }

    public static int findShortestSegWithSumAtMost(int[] a, long s) {
//        if(Arrays.stream(a).mapToObj(SegmentWithBigSum::bg).reduce(BigInteger.ZERO, BigInteger::add).compareTo(bg(s)) < 0) {
//            return  -1;
//        }
        int l = 0;
        long segmentSum = 0;
        int ans = Integer.MAX_VALUE;

        /*
            l7 10 4 3 20r 15 47 81 2 56 30 18 61 93 12 76  50
         */
        /* 7 20
        1   1   1   1       s = 4;
         */
        for (int r = 0; r < a.length; r++) {
            segmentSum += a[r];
            //we want ss >= s
            while(segmentSum >= s) {
                ans = Math.min(ans, r - l + 1);
                segmentSum -= a[l];
                l++;
            }
        }
        return ans == Integer.MAX_VALUE? -1 : ans;
    }


    static BigInteger bg(long a) {
        return new BigInteger(a + "");
    }

    private static int[]  readArray(Scanner sc, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        return a;
    }
}
