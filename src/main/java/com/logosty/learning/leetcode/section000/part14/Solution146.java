package com.logosty.learning.leetcode.section000.part14;

/**
 * @author logosty(ganyingle) on 2020/5/25 11:05
 * 146. LRU缓存机制 中等
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *  
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *  
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 * 缓存容量 )
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {

  private int capacity;
  private Map<Integer, Integer> map;
  private Map<Integer, Node> nodeMap;
  private Node head;
  private Node tail;

  public LRUCache(int capacity) {
    map = new HashMap<>(capacity + 1);
    nodeMap = new HashMap<>(capacity + 1);
    this.capacity = capacity;
  }

  public int get(int key) {
    Integer value = map.get(key);
    if (value == null) {
      return -1;
    }
    refresh(key);
    return value;
  }

  private void refresh(int key) {
    Node node = nodeMap.get(key);
    if (node == null) {
      Node current = new Node(key);
      nodeMap.put(key, current);
      if (head == null) {
        head = current;
        tail = current;
      } else {
        current.next = head;
        head.pre = current;
        head = current;
      }
      return;
    }

    if (node == head) {
      return;
    }
    if (node == tail) {
      tail = node.pre;
    } else {
      node.pre.next = node.next;
      node.next.pre = node.pre;
    }

    node.next = head;
    node.pre = null;
    head.pre = node;
    head = node;
  }

  public void put(int key, int value) {
    if (capacity == 1) {
      map.clear();
      map.put(key, value);
      return;
    }

    map.put(key, value);//
    refresh(key);

    if (map.size() > capacity) {
      doLRU();
    }
  }

  private void doLRU() {
    nodeMap.remove(tail.key);
    map.remove(tail.key);

    if (capacity == 1) {
      return;
    }
    tail.pre.next = null;
    tail = tail.pre;
  }
}

class Node {

  public int key;
  public Node pre;
  public Node next;

  public Node(int key) {
    this.key = key;
  }

  public Node(int key, Node pre, Node next) {
    this.key = key;
    this.pre = pre;
    this.next = next;
  }
}

public class Solution146 {

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2 /* 缓存容量 */);

    cache.put(2, 1);
    cache.put(2, 2);
    System.out.println(cache.get(2));
    cache.put(1, 1);
    cache.put(4, 1);
    System.out.println(cache.get(2));

  }


}
