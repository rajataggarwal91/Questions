import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

class TrieNode {
    char val;
    HashMap<Character, TrieNode> children;
    boolean isLeaf = false;

    TrieNode(char val) {
        this.val = val;
    }

}

public class Trie {

    static TrieNode originalRoot = new TrieNode('/');

    public static void main(String args[]) {
        //String[] dictionary = {"Hello","Hell","He"};
        insert("Hello");
        insert("He");
        System.out.println(check("Hell"));
        triePrinter();
    }


    private static void insert(String string) {
        int i = 0;
        TrieNode root = originalRoot;
        for (; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (root.children == null)
                root.children = new HashMap<>();
            if (!root.children.containsKey(ch)) {
                root.children.put(ch, new TrieNode(ch));
            }
            root = root.children.get(ch);
        }
            if (i == string.length()) root.isLeaf = true;
    }

  private static boolean check(String input) {
    TrieNode root = originalRoot;
    for (int i = 0 ; i < input.length(); i++) {
        if (root.children.containsKey(input.charAt(i))) {
            root = root.children.get(input.charAt(i));
        } else {
            return false;
        }
    }
    return root.isLeaf;
  }


  public static void triePrinter() {
        TrieNode root = originalRoot;
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);

      while(!queue.isEmpty()) {
            root = queue.remove();
            System.out.print(root.val + " ");
            if (root.isLeaf) System.out.print("-");
            if (root.children == null) continue;
            for (Entry<Character, TrieNode> entry : root.children.entrySet())
                queue.add(entry.getValue());
        }
  }

}
