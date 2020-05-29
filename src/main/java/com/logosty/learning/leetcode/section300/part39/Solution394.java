package com.logosty.learning.leetcode.section300.part39;

import java.util.Stack;

/**
 * @author logosty(ganyingle) on 2020/5/28 16:38
 * 394. 字符串解码 中等
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class Solution394 {

  Stack<StringBuilder> stack = new Stack<>();
  static final StringBuilder CONNECTION = new StringBuilder().append(".");
  static final StringBuilder LEFT = new StringBuilder().append("[");

  public String decodeString(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }

    for (char c : s.toCharArray()) {
      if ('[' == c) {
        stack.push(LEFT);
        continue;
      }
      if (']' == c) {
        doPop();
        continue;
      }
      if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
        pushString(new StringBuilder().append(c));
        continue;
      }
      if (c >= '0' && c <= '9') {
        stack.push(new StringBuilder().append(c));
      }
    }

    stack.pop();
    StringBuilder retSb = stack.pop();
    while (!stack.isEmpty()) {
      retSb = stack.pop().append(retSb);
    }
    return retSb.toString();
  }

  private void doPop() {
    StringBuilder lastSb = stack.pop();
    if (lastSb == CONNECTION) {
      lastSb = stack.pop();
    }
    stack.pop();

    StringBuilder lastInteger = stack.pop();
    while (!stack.isEmpty()) {
      StringBuilder last = stack.pop();
      if (!isInteger(last)) {
        stack.push(last);
        break;
      }
      lastInteger = last.append(lastInteger);
    }

    Integer integer = Integer.valueOf(lastInteger.toString());
    String target = lastSb.toString();
    lastSb.append(target.repeat(Math.max(0, integer - 1)));
    pushString(lastSb);
  }

  private void pushString(StringBuilder sb) {
    if (stack.isEmpty()) {
      stack.push(new StringBuilder().append(sb));
      stack.push(CONNECTION);
      return;
    }

    StringBuilder last = stack.pop();
    if (last == CONNECTION) {

      StringBuilder lastLast = stack.pop();
      stack.push(lastLast.append(sb));
      stack.push(CONNECTION);
      return;
    }
    stack.push(last);

    stack.push(new StringBuilder().append(sb));
    stack.push(CONNECTION);

  }

  private boolean isInteger(StringBuilder sb) {
    String s = sb.toString();
    return !s.equals("") && s.charAt(0) >= '0' && s.charAt(0) <= '9';
  }

  public static void main(String[] args) {
//    String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
//    String target = "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef";
    String s = "3[a2[c]]";
    String target = "";

    String ret = new Solution394().decodeString(s);
    System.out.println(ret);
    System.out.println(target);

    System.out.println(target.equals(ret));

//    System.out.println(new StringBuilder().toString());
  }
}
