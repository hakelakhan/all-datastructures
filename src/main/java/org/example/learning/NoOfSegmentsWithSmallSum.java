package org.example.learning;

import java.math.BigInteger;
import java.util.Scanner;

public class NoOfSegmentsWithSmallSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n =  sc.nextInt();
        long s = sc.nextLong();
        int[] a = readArray(sc, n);
//        int ans = goodSegmentCnt(a, s);
        BigInteger ans = goodSegmentCnt(a, s);
        System.out.printf("%s", ans.toString());
    }
    /*
    |2 (6 x4 3 |6)x 8 9
    4
      4
      n
     */

    public static BigInteger goodSegmentCnt(int[] a, long s) {

        int l = 0;
//        long ss = 0;
        BigInteger ss = BigInteger.ZERO;
        //2 6 4 l3r   s = 3    =>{2  3} =2
        //2 6 4 3 6 8 9     s = 20
        BigInteger cnt= bg(0);
        for (int r = 0; r < a.length; r++) {
//            ss += a[r];

            ss = ss.add(bg(a[r]));
            while(ss.compareTo(bg(s)) > 0) {
                ss = ss.subtract(bg(a[l]));
                l++;
            }
            if(l <= r) {
                int windowSize = r - l + 1;
                cnt = cnt.add( bg(windowSize));
            }
        }
        return cnt;
    }

    private static int[]  readArray(Scanner sc, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        return a;
    }

    static BigInteger bg(long a) {
        return new BigInteger(a + "");
    }
}
