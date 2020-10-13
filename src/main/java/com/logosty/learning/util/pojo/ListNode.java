package com.logosty.learning.util.pojo;

/**
 * @author logosty(ganyingle) on 2020/6/10 11:03
 */
public class ListNode {

  public int val;
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
