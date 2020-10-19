package com.logosty.learning.leetcode.section800.part84;

/**
 * @author logosty(ganyingle) on 2020/10/19 10:27
 * 844. 比较含退格的字符串 简单
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *
 *
 * 进阶：
 *
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 */
public class Solution844 {

  public boolean backspaceCompare(String S, String T) {
    char[] charsS = S.toCharArray();
    char[] charsT = T.toCharArray();

    int indexS = S.length() - 1;
    int indexT = T.length() - 1;
    int buffS = 0;
    int buffT = 0;

    while (true) {
      if (indexS >= 0 && charsS[indexS] == '#') {
        buffS++;
        indexS--;
        continue;
      }
      if (indexT >= 0 && charsT[indexT] == '#') {
        buffT++;
        indexT--;
        continue;
      }

      if (indexS >= 0 && buffS > 0) {
        buffS--;
        indexS--;
        continue;
      }
      if (indexT >= 0 && buffT > 0) {
        buffT--;
        indexT--;
        continue;
      }

      if (indexS < 0 && indexT < 0) {
        return true;
      }
      if (indexS < 0 || indexT < 0 || charsS[indexS] != charsT[indexT]) {
        return false;
      }
      indexS--;
      indexT--;
    }
  }

  public static void main(String[] args) {
    String s = "aaaa#b";
    String t = "a#aaa";
    System.out.println(new Solution844().backspaceCompare(s, t));
  }
}
