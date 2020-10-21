package com.logosty.learning.leetcode.section900.part92;

/**
 * @author logosty(ganyingle) on 2020/10/21 10:19
 * 925. 长按键入 简单
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 *
 *
 * 示例 1：
 *
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 *
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * 示例 3：
 *
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * 示例 4：
 *
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 *
 *
 * 提示：
 *
 * name.length <= 1000
 * typed.length <= 1000
 * name 和 typed 的字符都是小写字母。
 */

/**
 * 执行用时：
 * 1 ms
 * , 在所有 Java 提交中击败了
 * 86.83%
 * 的用户
 * 内存消耗：
 * 36.6 MB
 * , 在所有 Java 提交中击败了
 * 70.47%
 * 的用户
 */
public class Solution925 {
  public boolean isLongPressedName(String name, String typed) {
    if (name == null || name.length() == 0 || typed == null || typed.length() == 0) {
      return false;
    }

    int index = 0;
    char last = '#';
    for (int i = 0; i < typed.length(); i++) {
      if (index >= name.length()) {
        if (typed.charAt(i) != last) {
          return false;
        }
        continue;
      }

      if (typed.charAt(i) == name.charAt(index)) {
        last = name.charAt(index);
        index++;
        continue;
      }

      if (typed.charAt(i) != last) {
        return false;
      }
    }

    return index >= name.length();
  }

  public static void main(String[] args) {
    System.out.println(new Solution925().isLongPressedName("pyplrz","ppyypllr"));
  }
}
