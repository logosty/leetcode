package com.logosty.learning.util;


import com.logosty.learning.util.pojo.ListNode;

/**
 * @author logosty(ganyingle) on 2020/6/18 20:33
 */
public class ListNodeUtils {

  public static ListNode stringToListNode(String input) {
    // Generate array from the input
    int[] nodeValues = ArrayUtils.stringToIntegerArray(input);

    // Now convert that list into linked list
    ListNode dummyRoot = new ListNode(0);
    ListNode ptr = dummyRoot;
    for (int item : nodeValues) {
      ptr.next = new ListNode(item);
      ptr = ptr.next;
    }
    return dummyRoot.next;
  }

  public static String listNodeToString(ListNode node) {
    if (node == null) {
      return "[]";
    }

    String result = "";
    while (node != null) {
      result += Integer.toString(node.val) + ", ";
      node = node.next;
    }
    return "[" + result.substring(0, result.length() - 2) + "]";
  }
}
