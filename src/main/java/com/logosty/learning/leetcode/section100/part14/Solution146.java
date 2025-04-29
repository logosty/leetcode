package com.logosty.learning.leetcode.section100.part14;

/**
 * @author logosty(ganyingle) on 2025/4/29 21:56
 * description: 146. LRU 缓存 中等
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity
 * ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class Solution146 {
    class DoublyLinkedList {
        int key;
        int val;
        DoublyLinkedList next;
        DoublyLinkedList prev;
    }

    class LRUCache {
        private int capacity, size;
        private DoublyLinkedList head, tail;
        private Map<Integer, DoublyLinkedList> cache;

        public LRUCache(int capacity) {
            head = new DoublyLinkedList();
            tail = new DoublyLinkedList();
            head.next = tail;
            tail.prev = head;

            this.capacity = capacity;
            size = 0;
            cache = new HashMap<>();
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }

            DoublyLinkedList listNode = cache.get(key);
            moveToHead(listNode);
            return listNode.val;
        }

        private void moveToHead(DoublyLinkedList listNode) {
            if (head.next == listNode) {
                return;
            }

            if (listNode.prev != null) {
                listNode.prev.next = listNode.next;
            }
            if (listNode.next != null) {
                listNode.next.prev = listNode.prev;
            }

            head.next.prev = listNode;
            listNode.next = head.next;
            head.next = listNode;
            listNode.prev = head;
        }

        private void removeTail() {
            cache.remove(tail.prev.key);

            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                DoublyLinkedList listNode = cache.get(key);
                moveToHead(listNode);
                listNode.val = value;
                return;
            }

            DoublyLinkedList listNode = new DoublyLinkedList();
            listNode.val = value;
            listNode.key = key;
            moveToHead(listNode);
            cache.put(key, listNode);
            size++;

            if (size > capacity) {
                removeTail();
            }
        }
    }


}
