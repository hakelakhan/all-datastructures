package org.example;

import java.util.Scanner;

public class CodeForcesGoodSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--  > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int ans = solve(a);
            System.out.printf("%d\n", ans);
        }
    }
    static int solve(int[] a) {
        //2      3   4   5
        //1
        int min = 1;
        int n = a.length;
        for(int i = 0; i < n; i++) {
            if(a[i] == min) {
                min++;
            }
            min++;
        }
        return min -1;
    }
}
