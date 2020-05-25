package com.logosty.learning.leetcode.part46;

import java.util.HashMap;
import java.util.Map;

/**
 * @author logosty(ganyingle) on 2020/5/25 15:43
 * 460. LFU缓存 困难
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。
 *
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除最久未使用的键。
 * 「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 *
 *  
 *
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 *
 *  
 *
 * 示例：
 *
 * LFUCache cache = new LFUCache( 2  capacity (缓存容量)  );
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回 1
 * cache.put(3,3);    // 去除 key 2
 * cache.get(2);       // 返回 -1 (未找到key 2)
 * cache.get(3);       // 返回 3
 * cache.put(4,4);    // 去除 key 1
 * cache.get(1);       // 返回 -1 (未找到 key 1)
 * cache.get(3);       // 返回 3
 * cache.get(4);       // 返回 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lfu-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class LFUCache {

  int capacity;
  Node head;
  Node tail;
  Map<Integer, Integer> map;
  Map<Integer, Node> nodeMap;

  public LFUCache(int capacity) {
    this.capacity = capacity;

    if (capacity <= 0) {
      return;
    }
    map = new HashMap<>(capacity + 1);
    nodeMap = new HashMap<>(capacity + 1);
  }

  public int get(int key) {
    if (capacity <= 0) {
      return -1;
    }
    Integer val = map.get(key);
    if (val == null) {
      return -1;
    }
    if (capacity != 1) {
      refresh(key);
    }
    return val;
  }

  public void put(int key, int value) {
    if (capacity <= 0) {
      return;
    }

    if (capacity == 1) {
      map.clear();
      map.put(key, value);
      return;
    }
    map.put(key, value);
    refresh(key);
    if (map.size() > capacity) {
      doLFU();
      reBalance(tail);
    }
  }

  private void refresh(int key) {
    Node node = nodeMap.get(key);
    if (node == null) { //new node
      Node current = new Node(key);
      nodeMap.put(key, current);
      if (head == null) {
        head = current;
        tail = current;
        return;
      }

      tail.next = current;
      current.pre = tail;
      tail = current;
      if (map.size() <= capacity) {
        reBalance(current);
      }
      return;
    }

    node.count++;
    reBalance(node);
  }

  private void doLFU() {
    map.remove(tail.pre.key);
    nodeMap.remove(tail.pre.key);

    tail.pre.pre.next = tail;
    tail.pre = tail.pre.pre;

  }

  private void reBalance(Node node) {
    Node tmp = node;
    while (tmp.pre != null && tmp.pre.count <= node.count) {
      tmp = tmp.pre;
    }
    shiftNode(tmp, node);
  }

  private void shiftNode(Node pre, Node next) {
    if (pre == next) {
      return;
    }

    if (head == pre) {
      head = next;
    }
    if (next == tail) {
      tail = next.pre;
    }

    next.pre.next = next.next;
    if (next.next != null) {
      next.next.pre = next.pre;
    }

    if (pre.pre != null) {
      pre.pre.next = next;
    }
    next.pre = pre.pre;
    next.next = pre;
    pre.pre = next;
  }
}

class Node {

  int key;
  int count;
  Node pre;
  Node next;

  public Node(int key) {
    this.key = key;
    this.count = 1;
  }
}

public class Solution460 {

  public static void main(String[] args) {
    LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );
    System.out.println();
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1));       // 返回 1
    cache.put(3, 3);    // 去除 key 2
    System.out.println(cache.get(2));       // 返回 -1 (未找到key 2)
    System.out.println(cache.get(3));       // 返回 3
    cache.put(4, 4);    // 去除 key 1
    System.out.println(cache.get(1));       // 返回 -1 (未找到 key 1)
    System.out.println(cache.get(3));       // 返回 3
    System.out.println(cache.get(4));       // 返回 4
    
  }
}
