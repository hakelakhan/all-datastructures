package org.example.learning;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergeSortedArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[m];
        int[] b = new int[n];

        for(int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        int[] c = merge(a, b);
        System.out.printf("%s", Arrays.stream(c).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

    }

    private static int[] merge(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int[] c = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < m && j < n) {
            if(a[i] < b[j]) {
                c[k++] = a[i++];
            }
            else {
                c[k++] = b[j++];
            }
        }
        while(i < m) {
            c[k++] = a[i++];
        }
        while(j < n) {
            c[k++] = b[j++];
        }
        return c;
    }
}
