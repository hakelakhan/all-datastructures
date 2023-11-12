package org.example.learning;

import java.math.BigInteger;
import java.util.Scanner;

public class SegmentWithSmallSum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long s = sc.nextLong();
        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.printf("%d", printSegmentWithSmallSum(a, s));
    }

    private static int printSegmentWithSmallSum(int[] a, long s) {
        int l =0;
        //long ss = 0;
        BigInteger ss = BigInteger.ZERO;
        int res = 0;
        for (int r = 0; r < a.length; r++) {
            //ss+= a[r];
            ss = ss.add(new BigInteger(a[r] +""));
            while(ss.compareTo(bg(s))  > 0) {
                ss = ss.subtract(bg(a[l]));
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
    static BigInteger bg(long a) {
        return new BigInteger(a+"");
    }
}
