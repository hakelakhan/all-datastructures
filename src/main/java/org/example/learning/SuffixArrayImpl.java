package org.example.learning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SuffixArrayImpl {
    public static void main(String[] args) {
        String str = "abaabbbaaadfdffd";
        int[] sa = suffixArray(str);
        int[] lcp = buildLCPArray(str, sa);
        int[] lcpGfg = buildLCPArrayGfg(str, sa);
        int[] sg = saGfg(str);

        System.out.printf("--------------------\n");
        System.out.printf("%s\n", Arrays.toString(sa));
        System.out.printf("%s\n", Arrays.toString(sg));
        System.out.printf("--------------------\n");
        System.out.printf("--------------------\n");
        System.out.printf("%s\n", Arrays.toString(lcp));
        System.out.printf("%s\n", Arrays.toString(lcpGfg));
        System.out.printf("--------------------\n");
        System.out.printf("%s\n", str);
        System.out.printf("%s\n", Arrays.toString(sa));
        System.out.printf("%s", Arrays.stream(sa).mapToObj(ind -> str.substring(ind))
                .collect(Collectors.joining("\n")));

    }

    private static int[] buildLCPArrayGfg(String text, int[] suffixArray) {
        int n = text.length();
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[suffixArray[i]] = i;
        }

        int[] lcp = new int[n - 1];
        int k = 0;

        for (int i = 0; i < n; i++) {
            if (rank[i] == n - 1) {
                k = 0;
                continue;
            }

            int j = suffixArray[rank[i] + 1];
            while (i + k < n && j + k < n && text.charAt(i + k) == text.charAt(j + k)) {
                k++;
            }

            lcp[rank[i]] = k;

            if (k > 0) {
                k--;
            }
        }

        return lcp;

    }

    private static int[] buildLCPArray(String str, int[] sa) {
        /*
            str = banana
            a
            na
            ana
            nana
            anana
            banana
            -------------
            a
            ana
            anana
            banana
            na
            nana
         */

        int n = str.length();
        int[] lcp = new int[n];
        lcp[0] = 0;
        for(int i = 1; i < n; i++) {
            lcp[i] = commonPrefixBetween(str.substring(sa[i-1]), str.substring(sa[i]));
        }
        return lcp;
    }

    private static int commonPrefixBetween(String str1, String str2) {
        int i = 0;

        while(i < str1.length() && i < str2.length() && str1.charAt(i) == str2.charAt(i))  {
            i++;
        }
        return i;
    }

    private static int[] suffixArray(String str) {
        int n = str.length();
        Map<Integer, String> suffices = new LinkedHashMap<>();
        /*
                ababbba
                babbba
                abba
                bba
                ba
                a
         */
        for(int i = 0; i < n; i++) {
            suffices.put(i, str.substring(i));
        }
        return suffices.entrySet().stream().sorted(
                Comparator.comparing(Map.Entry::getValue)
                ).mapToInt(Map.Entry::getKey).toArray();
    }
    static int[] saGfg(String s) {
        int n = s.length();
        int[] suffix = new int[n];
        String[] sub = new String[n];

        // Mapping string with its index of
        // it's last letter.
        for (int i = 0; i < n; i++) {
            sub[i] = s.substring(i);
        }

        // Sorting all substrings
        Arrays.sort(sub);

        // Storing all values of map
        // in suffix array.
        for (int i = 0; i < n; i++) {
            suffix[i] = n - sub[i].length();
        }
        return  suffix;

    }
}
