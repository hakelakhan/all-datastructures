package problems;

import java.util.Scanner;

public class MainClass {
    static enum Command{
        INSERT("insert"),
        COUNT_WORDS_EQUAL_TO("countWordsEqualTo"),
        COUNT_WORDS_START_WITH("countWordsStartingWith"),
        ERASE("erase");
        private String command;
        Command(String str) {
            this.command = str;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i = 0; i < tc; i++) {
            Trie trie = new Trie();
            int n = sc.nextInt();
            sc.nextLine();
            for(int j = 0; j < n; j++) {
                String str = sc.nextLine();
                String[] split = str.split(" ");
                String command = split[0];
                String value = split[1];
                int op = switch(command) {
                    case "insert" -> {
                        trie.insert(value);
                        yield 0;
                    }
                    case "countWordsEqualTo" -> trie.countWordsEqualTo(value);
                    case "countWordsStartingWith" -> trie.countWordsStartingWith(value);
                    case "erase" -> {
                        trie.erase(value);
                        yield 0;
                    }
                    default -> 0;
                };
                 System.out.printf("%d\n", op);
            }


        }


    }
}
