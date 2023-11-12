package org.example.learning;

import java.math.BigInteger;
import java.util.Scanner;

public class NoOfSegmentswithBigSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long s = sc.nextLong();
        int[] a= readArray(sc, n);
        var ans = findAns(a, s);
        System.out.printf("%s", ans);
    }

    static BigInteger bg(long a) {
        return new BigInteger(a + "");
    }
    public static BigInteger findAns(int[] a, long s) {
        int l = 0;
        //3 3 3     , 3
        var segsum = bg(0);
        var cnt = bg(0);
        for (int r = 0; r < a.length; r++) {
//            segsum += a[r];
            segsum = segsum.add(bg(a[r]));
            while (segsum.compareTo(bg(s)) > 0) {
//            while (segsum > s) {
//                segsum -= a[l];
                segsum = segsum.subtract(bg(a[l]));
                int tmp = (a.length -1) -r + 1;
//                cnt += ;
                cnt = cnt.add(bg(tmp));
                l++;
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
}
