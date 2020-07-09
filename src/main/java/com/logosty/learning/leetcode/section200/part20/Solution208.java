package com.logosty.learning.leetcode.section200.part20;

/**
 * @author logosty(ganyingle) on 2020/7/9 19:42
 * 208. 实现 Trie (前缀树) 中等
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
public class Solution208 {

  public static void main(String[] args) {
    Trie trie = new Trie();

    trie.insert("apple");
    System.out.println(trie.search("apple"));   // 返回 true
    System.out.println(trie.search("app"));     // 返回 false
    System.out.println(trie.startsWith("app")); // 返回 true
    trie.insert("app");
    System.out.println(trie.search("app"));     // 返回 true
  }

  static class Trie {

    Node root;

    /** Initialize your data structure here. */
    public Trie() {
      root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
      Node node = root;
      for (char c : word.toCharArray()) {
        if (node.next == null) {
          node.next = new Node[26];
        }
        int offset = c - 'a';
        if (node.next[offset] == null) {
          Node nextNode = new Node();
          node.next[offset] = nextNode;
          node = nextNode;
        } else {
          node = node.next[offset];
        }
      }
      node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
      Node node = root;
      for (char c : word.toCharArray()) {
        if (node.next == null) {
          return false;
        }
        int offset = c - 'a';
        if (node.next[offset] == null) {
          return false;
        } else {
          node = node.next[offset];
        }
      }
      return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
      Node node = root;
      for (char c : prefix.toCharArray()) {
        if (node.next == null) {
          return false;
        }
        int offset = c - 'a';
        if (node.next[offset] == null) {
          return false;
        } else {
          node = node.next[offset];
        }
      }
      return true;
    }

    private class Node {

      boolean isEnd;
      Node[] next;

      public Node() {
      }
    }
  }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
