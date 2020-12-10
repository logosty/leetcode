package com.logosty.learning.leetcode.section700.part70;

/**
 * @author logosty(ganyingle) on 2020/12/10 10:28
 * 707. 设计链表 中等
 * 设计链表的实现。您可以选择使用单链表或双链表。
 * 单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，
 * 则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 *
 * 示例：
 *
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *
 *
 * 提示：
 *
 * 所有val值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 */

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
public class Solution707 {

  public static void main(String[] args) {
    MyLinkedList obj = new MyLinkedList();
    obj.addAtHead(1);
    obj.addAtTail(3);
    obj.addAtIndex(1, 2);
    obj.deleteAtIndex(1);
    System.out.println(obj.get(1));
  }

  /**
   * 执行用时：
   * 13 ms
   * , 在所有 Java 提交中击败了
   * 54.66%
   * 的用户
   * 内存消耗：
   * 39.3 MB
   * , 在所有 Java 提交中击败了
   * 35.21%
   * 的用户
   */
  static class MyLinkedList {

    Node head = new Node(null, null, -1);
    Node tail = new Node(null, null, -1);
    int length;

    /** Initialize your data structure here. */
    public MyLinkedList() {
      head.next = tail;
      tail.pre = head;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
      if (index < 0 || index >= length) {
        return -1;
      }

      Node node = find(index);
      return node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
      Node node = new Node(val);

      Node next = head.next;
      head.next = node;
      node.pre = head;
      node.next = next;
      next.pre = node;
      length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
      Node node = new Node(val);

      Node pre = tail.pre;
      tail.pre = node;
      node.next = tail;
      node.pre = pre;
      pre.next = node;
      length++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
      if (index <= 0) {
        addAtHead(val);
        return;
      }
      if (index == length) {
        addAtTail(val);
        return;
      }
      if (index > length) {
        return;
      }
      Node cur = new Node(val);

      Node node = find(index);
      Node pre = node.pre;
      pre.next = cur;
      cur.pre = pre;
      node.pre = cur;
      cur.next = node;
      length++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
      if (index < 0 || index >= length) {
        return;
      }
      Node node = find(index);
      Node pre = node.pre;
      Node next = node.next;
      pre.next = next;
      next.pre = pre;

      length--;
    }

    private Node find(int index) {
      Node res = head;
      for (int i = 0; i <= index; i++) {
        res = res.next;
      }
      return res;
    }

    class Node {

      Node pre;
      Node next;
      int val;

      public Node(int val) {
        this.val = val;
      }

      public Node(Node pre, Node next, int val) {
        this.pre = pre;
        this.next = next;
        this.val = val;
      }
    }

  }
}
