package org.example;

import java.util.Scanner;

public class CodeForcesSimpleDesing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--  > 0) {
            int x= sc.nextInt();
            int k = sc.nextInt();
            int ans = solve(x, k);
            System.out.println(ans);
        }
    }

    private static int solve(int x, int k) {
        for (int i = 0; i < 20; i++) {
            if(getSumOfDigits(x) % k ==0) {
                return x;
            }
            x++;
        }
        return 0;
    }
    static int getSumOfDigits(int x) {


        int sum = 0;
        while(x > 0) {
            sum += (x % 10);
            x = x /10;
        }
        return sum;

    }
}
