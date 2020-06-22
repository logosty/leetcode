package com.logosty.learning.leetcode.section400.part42;

import java.util.HashMap;
import java.util.Map;

/**
 * @author logosty(ganyingle) on 2020/6/22 15:29
 * 432. 全 O(1) 的数据结构 困难
 * 请你实现一个数据结构支持以下操作：
 *
 * Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 * Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否则使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
 * GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串"" 。
 * GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 *
 *
 * 挑战：
 *
 * 你能够以 O(1) 的时间复杂度实现所有操作吗？
 */
public class Solution432 {

  static class AllOne {

    Map<String, Integer> map;
    Map<String, Node> cache;
    Node head;
    Node tail;

    /** Initialize your data structure here. */
    public AllOne() {
      map = new HashMap<>();
      cache = new HashMap<>();
      head = new Node("Position_Head_Node");
      tail = new Node("Position_Tail_Node");
      head.next = tail;
      tail.pre = head;

      map.put(head.key, Integer.MAX_VALUE);
      map.put(tail.key, 0);
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
      if (!map.containsKey(key)) {
        map.put(key, 1);
        Node node = new Node(key);
        cache.put(key, node);

        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;


        return;
      }

      map.put(key, map.get(key) + 1);
      Node node = cache.get(key);
      left(node);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
      if (!map.containsKey(key)) {
        return;
      }

      Node node = cache.get(key);

      if (map.get(key) == 1) {
        map.remove(key);
        cache.remove(key);
        Node pre = node.pre;
        Node next = node.next;

        pre.next = node.next;
        next.pre = node.pre;
        return;
      }

      map.put(key, map.get(key) - 1);
      right(node);
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
      if (head.next != tail) {
        return head.next.key;
      }
      return "";
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
      if (tail.pre != head) {
        return tail.pre.key;
      }
      return "";
    }

    public void left(Node node) {
      while (true) {
        Node pre = node.pre;
        Node next = node.next;
        if (map.get(pre.key) >= map.get(node.key)) {
          return;
        }

        next.pre = node.pre;

        pre.pre.next = node;

        node.pre = pre.pre;
        node.next = pre;

        pre.next = next;
        pre.pre = node;
      }
    }

    public void right(Node node) {

      while (true) {
        Node pre = node.pre;
        Node next = node.next;
        if (map.get(node.key) >= map.get(next.key)) {
          return;
        }

        pre.next = next;

        next.next.pre = node;

        node.next = next.next;
        node.pre = next;

        next.pre = pre;
        next.next = node;
      }
    }

    class Node {

      public Node pre;
      public Node next;
      public String key;

      Node(String key) {
        this.key = key;
      }
    }
  }




  public static void main(String[] args) {
    AllOne allOne = new AllOne();
    allOne.inc("a");
    allOne.inc("b");
    allOne.inc("b");
    allOne.inc("b");
    allOne.inc("b");


    allOne.dec("b");
    allOne.dec("b");


    System.out.println(allOne.getMaxKey() + ":b");
    System.out.println(allOne.getMinKey() + ":a");



  }
/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
}
