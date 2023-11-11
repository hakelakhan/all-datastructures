package org.example.learning;

import java.util.Scanner;

public class NoEquals {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] a= readArray(sc, m);
        int[] b= readArray(sc, n);

        long sum = getSum(m, n, a, b);

        System.out.printf("%d", sum);
    }

    public static long getSum(int m, int n, int[] a, int[] b) {
        int[] c= new int[m + n];
        boolean[] flag = new boolean[m + n];

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < m && j < n) {
            if(a[i] < b[j] ) {
                c[k] = a[i++] ;
                flag[k++] = false;
            }
            else if(a[i] >= b[j] ) {
                c[k] = b[j++];
                flag[k++] = true;
            }
        }
        while(i < m) {
            flag[k] = false;
            c[k++] = a[i++] ;
        }
        while(j < n) {
            flag[k] = true;//true means element is from b array
            c[k++] = b[j++];
        }

        int prev = c[0];
        int ucnt = !flag[0] ? 1 : 0;
        int dcnt = flag[0] ? 1 : 0;
        long sum = 0;
        boolean calc = false;
        for (k = 1; k < m + n; k++) {
            if(c[k] == prev) {
                if(flag[k]) {
                    dcnt++;
                }
                else {
                    ucnt++;
                }
                calc = false;
            }
            else {
                sum += ucnt* dcnt;
                calc = true;
                //upcnt * dnCont
                //reset
                prev = c[k];
                ucnt = !flag[k] ? 1 : 0;
                dcnt = flag[k] ? 1 : 0;
            }

        }
        if(!calc) {
            sum  += ucnt*dcnt;
        }
        return sum;
    }

    private static int[]  readArray(Scanner sc, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        return a;
    }
}
