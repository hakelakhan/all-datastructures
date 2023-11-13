package org.example.learning;

import java.util.Scanner;

public class DateProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int distance = sc.nextInt();
        int[] a = readArray(sc, n);
        var ans = solve(a, distance);
        System.out.printf("%d", ans);
    }
    public static long solve(int[] a, int distance)  {
        //1 3   5   8
        /*
                1 8 ...
         */


        int l = 0;
        long cnt = 0;
        for (int r = 0; r < a.length; r++) {
            while(a[r] - a[l] > distance) {
                cnt += (a.length -1 -r + 1);
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
