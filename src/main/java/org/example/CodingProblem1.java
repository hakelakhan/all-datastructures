package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class CodingProblem1 {
    /*
    6
    2
    01
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            String str = sc.next();
            makeGoodString(str, n);
        }

    }

    private static void makeGoodString(String str, int n) {
        int ops = 0;
        List<Integer> indices = new ArrayList<>();
        Deque<Character> deque = new ArrayDeque<>();
        if( (n & 1) == 1) {
            System.out.println("-1");
            return;
        }
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            deque.addLast(ch);
        }
        int i = 0;
        while(!deque.isEmpty() && ops <= 300) {
            if(deque.getFirst() != deque.getLast()) {
                deque.removeFirst();
                deque.removeLast();
            }
            else if(deque.getFirst() == '0') {
                //   001110
                //
                //         0-----------0
                indices.add(i + deque.size());
                deque.removeFirst();
                deque.addLast('0');
                ops++;
            }
            else {
                //    0|1  1------ |1
                indices.add(i);
                deque.removeLast();
                deque.addFirst('1');
                ops++;
            }
            i++;
        }
        if(ops <=300) {
            System.out.printf("%d\n%s\n", ops, indices.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
        else {
            System.out.printf("-1\n");
        }
    }
}
/*
0

-1
-1
2
6 7
1
10
-1

 */
