package com.logosty.learning.util.pojo;

import java.util.List;

/**
 * @author logosty(ganyingle) on 2020/10/15 17:16
 */
public class Node {

  public int val;
  public Node left;
  public Node right;
  public Node next;
  public List<Node> children;
  public Node random;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }
}
