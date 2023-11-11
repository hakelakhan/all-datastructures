package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Problem2 {
    static int[] power = new int[31];
    public static void main(String[] args) {
        for (int i = 0; i < power.length; i++) {
            power[i] = 1 << i;
        }
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
        int[] ns = getNextSmaller(x);
        int n = a.length;
        int q = x.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k < q; k++) {
            if(!map.containsKey(x[k])) {
                map.put(x[k], k);
            }

        }
        for (int j = 0; j < n; j++) {
            int d = q + 2;
            int c = a[j];
            for (int k = 1; k <= 30; k++) {
                if(map.containsKey(k) && a[j] % power[k] == 0) {
                    d = Math.min(d, map.get(k));
                }
            }

            while (d < q) {
                c += power[(int) (x[(int) d] - 1)];
                d = ns[(int) d];
            }
            a[j] = c;
        }
    }

    public static int[] getNextSmaller(int[] a) {
        int n = a.length;
        int[] ns = new int[n];
        /*
        //808 34 134 12 1  9 43 123 314 45   int n = 10
                                45   45  ---
                                        [45  123
         */
        Stack<Integer> st = new Stack<>();
        ns[n-1] = n;
        st.push(n -1);
        for(int i = n - 2; i >= 0; i--) {

            while(!st.isEmpty() && (st.peek() != n && a[st.peek()] > a[i])) {
                st.pop();
            }
            ns[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return ns;
    }

    static void modifyArray2(int[] a, int[] x) {
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
/*
1 2 3 6 6
7 10 14 38 58 6 3
3 3 3 3 3
1 3 7 11 19

 */