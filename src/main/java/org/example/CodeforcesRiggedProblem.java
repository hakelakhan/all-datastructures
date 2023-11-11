package org.example;

import java.util.Scanner;

public class CodeforcesRiggedProblem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--  > 0) {
            int n = sc.nextInt();
            int[] s = new int[n];
            int[] e = new int[n];

            for(int i = 0; i < n; i++) {
                s[i] = sc.nextInt();
                e[i] = sc.nextInt();
            }
            int ans = giveWeight(s, e, n);
            System.out.printf("%d\n", ans);

        }
    }

    private static int giveWeight(int[] s, int[] e, int n) {
        int highW = s[0];
        int minW = 1;
        /*
               -00       7


         */

        for(int i = 1; i < n; i++) {
            if(e[i] >= e[0]) {
                minW = Math.max(minW, s[i] + 1);
                if(minW > highW) {
                    return -1;
                }
            }
        }

        return minW;
    }
}

