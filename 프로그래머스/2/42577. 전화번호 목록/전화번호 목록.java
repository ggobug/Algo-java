import java.util.*;

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfNumber;

    public TrieNode() {
        this.isEndOfNumber = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public boolean insert(String number) {
        TrieNode node = root;
        boolean isNewNumber = false;

        for (char c : number.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
                isNewNumber = true;
            }
            node = node.children.get(c);
            if (node.isEndOfNumber) {
                return false; // 접두어가 이미 존재
            }
        }

        node.isEndOfNumber = true;
        return isNewNumber;
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        
        Trie trie = new Trie();

        for (String number : phone_book) {
            if (!trie.insert(number)) {
                return false; // 접두어 관계 발견
            }
        }

        return true;
    }
}