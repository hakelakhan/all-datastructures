package org.example.learning;

import java.util.Scanner;

public class SongsPlayer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long p = sc.nextLong();
        int[] a=  readArray(sc, n);
        solve(a,p);
    }

    private static void solve(int[] a, long p) {
        int n = a.length;
        //1 2 3 4 5 4 3 2 1     1 2 3 4 5 4 3 2 1       1 2 3 4 5 4 3 2 1
        int minSongCnt = Integer.MAX_VALUE;
        int minStarting = Integer.MAX_VALUE;
        long moodCnt = 0;
        int l = 0;
        for (int r = 0;  (minSongCnt == Integer.MAX_VALUE || r < n * 2); r++) {
            moodCnt += a[r % n];
            while(moodCnt >= p) {
                //System.out.printf("%d %d\n", l + 1, r -l +1);
                if(r - l + 1 < minSongCnt) {
                    minStarting = l + 1;
                    minSongCnt = r - l + 1;
                }
                moodCnt-= a[l% n];
                l++;
            }
        }

        System.out.printf("%d %d\n", minStarting, minSongCnt);



    }

    private static int[]  readArray(Scanner sc, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        return a;
    }
}
