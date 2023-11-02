package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Read the number of test cases

        while(t-- > 0) {
            int n = scanner.nextInt(); // Read the length of the array a
            int q = scanner.nextInt(); // Read the number of queries

            int[] a = new int[n];
            int[] x = new int[q];

            // Read the elements of the array a
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }

            // Read the modification queries
            for (int j = 0; j < q; j++) {
                x[j] = scanner.nextInt();
            }
            modifyArray(a, x);
            System.out.println(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }

        scanner.close();
    }


    static void modifyArray(int[] a, int[] x) {
        int n = a.length; 
        int q = x.length;
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < n; j++) {
                if(a[j] % (1<<x[i]) == 0) {
                    a[j] = a[j] + (1 <<(x[i] -1));
                }
            }
        }
    }
}
