package com.logosty.learning.leetcode.section700.part76;

/**
 * @author logosty(ganyingle) on 2020/11/30 15:09
 * 767. 重构字符串 中等
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 *
 */
public class Solution767 {

  public static void main(String[] args) {
    System.out.println(new Solution767().reorganizeString("vvvlo"));
  }

  /**
   * 执行用时：
   * 1 ms
   * , 在所有 Java 提交中击败了
   * 97.65%
   * 的用户
   * 内存消耗：
   * 36.6 MB
   * , 在所有 Java 提交中击败了
   * 75.75%
   * 的用户
   * @param S
   * @return
   */
  public String reorganizeString(String S) {
    int[] cache = new int[26];
    int max = -1;
    int maxOffset = -1;
    for (int i = 0; i < S.length(); i++) {
      int index = S.charAt(i) - 'a';
      cache[index]++;

      if (cache[index] > max) {
        max = cache[index];
        maxOffset = index;
      }
      if (cache[index] > S.length() / 2 + ((S.length() & 1) == 1 ? 1 : 0)) {

        return "";
      }
    }

    int each = S.length() / max + (S.length() % max == 0 ? 0 : 1);
    int[] res = new int[max * each];
    for (int i = 0; i < max; i++) {
      res[i * each] = maxOffset + 1;
    }
    int turn = 1;
    int offset = 0;
    for (int i = 0; i < cache.length; i++) {
      if (i == maxOffset) {
        continue;
      }
      for (int j = 0; j < cache[i]; j++) {
        res[offset * each + turn] = i + 1;
        offset++;
        if (offset == max) {
          offset = 0;
          turn++;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i : res) {
      if (i == 0) {
        continue;
      }
      sb.append((char) ((i - 1) + 'a'));
    }

    return sb.toString();
  }
}
