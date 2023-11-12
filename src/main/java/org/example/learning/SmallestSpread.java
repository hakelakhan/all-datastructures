package org.example.learning;

import java.util.Scanner;
import java.util.TreeMap;

public class SmallestSpread {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = readArray(sc, n);
        var ans = getCnt(a, k);
        System.out.printf("%d", ans);
    }
    static long getCnt(int[] a, int k) {
        int l = 0;
        long cnt = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int r = 0; r < a.length; r++) {
            //add
            map.compute(a[r], (key, value) -> value == null ? 1 : value + 1);
            while(!map.isEmpty() && (map.lastKey() -map.firstKey()) > k) {
                //remove a[l]
                map.compute(a[l], (key, value) ->  value == 1 ? null : value - 1);
                l++;
            }
            cnt+= r -l + 1;

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
