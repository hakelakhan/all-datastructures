package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problm1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String elements = br.readLine();
            String[] el = elements.split(" ");
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(el[i]);
            }
            if(canBeSorted(a)) {
                System.out.printf("TRUE\n");
            }
            else {
                System.out.printf("FALSE\n");
            }

        }
        /*
        8
        5
        1 2 3 4 5
        5
        6 5 3 4 4
        9
        6 5 5 7 5 6 6 8 7
        4
        4 3 2 1
        6
        2 2 4 5 3 2
        8
        1 3 17 19 27 57 179 13
        5
        3 17 57 179 92
        10
        1 2 3 4 0 6 7 8 9 10

             */
    }
    static boolean canBeSorted(int[] a) {
            int n = a.length;
        int m = 2;

        while(m * 2 <= n) {
            //0 based indexing
            int start = m + 1;  //3
            int end = m* 2;     //4
            if(!isArraySorted(a, start -1 , end -1)) {
                return false;
            }
            m = m * 2;
        }
        return isArraySorted(a, m* 2, n -1);
    }
    static boolean isArraySorted(int[] a, int low, int high) {
        int n = high -low + 1;
        if(n <= 1) {
            return true;
        }
        while(low + 1 <= high) {
            if(a[low +1] < a[low++]) {
                return false;
            }
        }
        return true;
    }
}
