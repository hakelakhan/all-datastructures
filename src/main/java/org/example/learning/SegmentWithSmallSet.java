package org.example.learning;

import java.util.*;

public class SegmentWithSmallSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int k = sc.nextInt();
        int[] a= readArray(sc, n);
        var ans = getCount(a, k);
        System.out.printf("%s", String.valueOf(ans));
    }
    static long getCount(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        long cnt = 0;
        int l = 0;
        for (int r = 0; r < a.length; r++) {
            //add(a[r])
            map.compute(a[r], (key, value) -> value == null ? 1 : value + 1);

            while(map.size() > k) {
                //remove(a[l])
                map.compute(a[l], (key, value) -> value == 1 ? null : value -1);
                l++;
            }
            cnt += r- l + 1;
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
