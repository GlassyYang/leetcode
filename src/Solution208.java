import java.rmi.UnexpectedException;
import java.util.*;

public class Solution208 {
}

class Trie {

    static class TreeNode {
        char c;
        boolean isWord = false;
        List<TreeNode> child = new ArrayList<>();

        public TreeNode(char c) {
            this.c = c;
        }
    }

    TreeNode root = new TreeNode('\u0000');

    /** Initialize your data structure here. */
    public Trie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TreeNode next = null;
            for (TreeNode child : node.child) {
                if (child.c == c) {
                    next = child;
                    break;
                }
            }
            if (next == null) {
                next = new TreeNode(c);
                node.child.add(next);
            }
            node = next;
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TreeNode next = null;
            for (TreeNode child : node.child) {
                if (child.c == c) {
                    next = child;
                    break;
                }
            }
            if (next == null) return false;
            node = next;
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            TreeNode next = null;
            for (TreeNode child : node.child) {
                if (child.c == c) {
                    next = child;
                    break;
                }
            }
            if (next == null) return false;
            node = next;
        }
        return true;
    }
}
