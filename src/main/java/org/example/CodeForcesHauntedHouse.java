package org.example;

import java.util.Scanner;

public class CodeForcesHauntedHouse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--  > 0) {
            int n = sc.nextInt();
            String str = sc.next();
            solve(str, n);
        }
    }
    static void solve(String str, int n) {
        int nz = countZeros(str);
        for (int i = 1; i < n; i++) {
            if(nz < i)  {
                System.out.printf("%d ", -1);
                continue;
            }
            int noOfOps = noOfOps(str, i);
            System.out.printf("%d ", noOfOps);
        }
        System.out.printf("-1\n");
    }

    private static int countZeros(String str) {
        int cnt = 0;
        int n = str.length();
        for(int i = 0; i < n; i++) {
            if(str.charAt(i) == '0') {
                cnt++;
            }
        }
        return cnt;
    }

    private static int noOfOps(String str, int lastZerosWeWant) {
        //10101   n = 5, end = 3

        //3-1 =>2
        //4-2 => 2
        //3, 4
        int zerosWeGot = 0;
        int n = str.length();
        int end = n -1;
        while(end >= 0 && str.charAt(end) == '0') {
            end--;
            zerosWeGot++;
        }
        if(zerosWeGot >= lastZerosWeWant) {
            return 0;
        }
        int ops = 0;
        while(zerosWeGot < lastZerosWeWant && end >= 0) {
            if(str.charAt(end) == '0') {
                int posFromLast = n - 1 - end;  //7 -->
                ops += posFromLast - zerosWeGot;
                zerosWeGot++;
            }
            end--;
        }
        if(zerosWeGot == lastZerosWeWant) {
            return ops;
        }
        return -1;
    }
}
