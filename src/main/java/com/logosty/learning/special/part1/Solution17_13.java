package com.logosty.learning.special.part1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author logosty(ganyingle) on 2020/7/9 17:54
 * 面试题 17.13. 恢复空格 中等
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。
 * 像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。
 * 在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。
 * 假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 *
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 *
 *
 *
 * 示例：
 *
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * 提示：
 *
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 */
public class Solution17_13 {

  static class Node {

    public Node getNext(char c) {
      if (next == null) {
        return null;
      }
      return next[c - 'a'];
    }

    public boolean hasNext(char c) {
      return getNext(c) != null;
    }

    boolean isEnd;
    Node[] next;

    public Node() {
    }
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

  }

  Map<Integer, Integer> cache;

  public int respace(String[] dictionary, String sentence) {
    Trie trie = new Trie();
    for (String word : dictionary) {
      trie.insert(word);
    }
    cache = new HashMap<>();

    return identify(trie, sentence.toCharArray(), 0);
  }

  public int identify(Trie trie, char[] chars, int begin) {
    if (begin >= chars.length) {
      return 0;
    }
    if (cache.get(begin) != null) {
      return cache.get(begin);
    }

    Node node = trie.root;

    List<Integer> rets = new ArrayList<>();
    rets.add(1 + identify(trie, chars, begin + 1));

    for (int i = 0; i + begin < chars.length; i++) {
      char c = chars[i + begin];
      if (!node.hasNext(c)) {
        rets.add(i + 1 + identify(trie, chars, begin + i + 1));
        break;
      }
      node = node.getNext(c);
      if (node.isEnd) {
        rets.add(identify(trie, chars, begin + i + 1));
      }
    }
    int ret = rets.stream().min(Integer::compareTo).orElse(0);
    cache.put(begin, ret);
    return ret;
  }

  public static void main(String[] args) {
    String[] strings = {"looked", "just", "like", "her", "brother"};
    String s = "jesslookedjustliketimherbrother";
    System.out.println(new Solution17_13().respace(strings, s));
  }
}
