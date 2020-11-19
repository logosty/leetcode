package com.logosty.learning.util.pojo2;

import java.util.List;

/**
 * @author logosty(ganyingle) on 2020/11/19 11:30
 */
public class Node {

  public int val;
  public List<Node> children;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }
};
