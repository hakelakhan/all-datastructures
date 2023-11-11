package org.example.learning;

import java.util.Scanner;

public class SmallerNoCount {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] a= readArray(sc, m);
        int[] b= readArray(sc, n);
        int i= 0;
        int j =0;
        int cnt = 0;
        while(j < b.length && i < a.length) {
            if( a[i] < b[j]) {
                cnt++;
                i++;

            }
            else if(a[i] >= b[j] ) {
                System.out.printf("%d ", cnt);
                //1
                j++;
            }
        }
            /* a 1 6 9 13 18 18 20 22i 23 23 23 23 23 24
               b 2 3 8 13j 15 21 25j */
        while(j < b.length) {
            System.out.printf("%d ", cnt);
            j++;
        }

        //i is ptr for array b
    }


    private static int[]  readArray(Scanner sc, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        return a;
    }
}

