package structures;

import java.util.HashMap;
import java.util.Map;

public class Trie {
  private TrieNode root;

  public Trie() { root = new TrieNode(); }

  public void insert(String word) {
    TrieNode current = root;

    for (char c : word.toCharArray()) {
      current.children.putIfAbsent(c, new TrieNode());
      current = current.children.get(c);
    }

    current.isWord = true;
  }

  private static class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord;
  }
}
