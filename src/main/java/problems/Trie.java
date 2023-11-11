package problems;

public class Trie {
    private final char lastChar = 'z' + 1;
    private final char dummyChar = 'z' + 2;
    private final int size = 28;
    private final Node root;
    class Node {
        char data;
        Node[] children;
        int insertCnt;
        int childCnt;
        Node() {
            this(dummyChar);
        }
        Node(char data ) {
            this.data = data;
            children = new Node[size];
            this.insertCnt = 0;
            this.childCnt = 0;
        }
    }
    public Trie() {
        // Write your code here.
        root = new Node();
    }

    public void insert(String str) {
        // Write your code here.
        int n = str.length();
        Node tmp = root;
        for(int i = 0; i < n + 1; i++) {
            char ch = i == n ? lastChar: str.charAt(i);
            if(tmp.children[ch - 'a'] == null) {
                tmp.children[ch - 'a'] = new Node(ch);
                tmp.childCnt++;
            }
            tmp = tmp.children[ch - 'a'];
            if(i == n) {
                tmp.insertCnt++;
            }

        }
    }
    public int countWordsEqualTo(String str) {
        // Write your code here.

        int n = str.length();
        Node tmp = root;
        for(int i = 0; i < n + 1; i++) {
            char ch = i == n ? lastChar: str.charAt(i);


            if(tmp.children[ch - 'a'] == null) {
                return 0;
            }
            tmp = tmp.children[ch - 'a'];
            if(i == n) {
                return tmp.insertCnt;
            }

        }
        return 0;
    }

    public int countWordsStartingWith(String str) {
        // Write your code here.
        int n = str.length();
        Node tmp = root;
        for(int i = 0; i < n ; i++) {
            char ch = str.charAt(i);
            if(tmp.children[ch - 'a'] == null) {
                return 0;
            }
            tmp = tmp.children[ch - 'a'];
        }
        return tmp.childCnt;
    }

    public void erase(String str) {
        //     coding
        //root
        //     ninja
        int n = str.length();
        Node tmp = root;
        for(int i = 0; i < n + 1 ; i++) {
            char ch = i == n ? lastChar : str.charAt(i);
            boolean shouldChildBeDeleted =
                    tmp.children[ch - 'a'].childCnt == 1;
            if(shouldChildBeDeleted) {
                Node chainToBeDeleted = tmp.children[ch - 'a'];
                tmp.children[ch - 'a'] = null;
                deleteChain(chainToBeDeleted, str.substring(i));
                tmp.childCnt--;
                break;
            }
        }

    }
    public void deleteChain(Node head , String str) {
        str = str + lastChar;
        Node tmp = head;
        //head.data = str.charAt(0)    c   o d i n g
        int i = 1;
        while(tmp != null) {
            Node ntd = tmp;
            tmp = i == str.length() ? null : tmp.children[str.charAt(i++) - 'a'];
             for (int j = 0; j < ntd.children.length; j++) {
                 if(ntd.children[j] != null) {
                     ntd.children[j] = null;
                 }

            }
            ntd.children = null;
        }

    }

}

