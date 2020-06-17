package com.logosty.learning.leetcode.section1000.part118;

/**
 * @author logosty(ganyingle) on 2020/6/17 16:49
 * 1189. “气球” 的最大数量 简单
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 *
 *
 *
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 *
 * 输入：text = "leetcode"
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 * https://leetcode-cn.com/problems/maximum-number-of-balloons/
 */
public class Solution1189 {

  public int maxNumberOfBalloons(String text) {
    if (text.length() < 7) {
      return 0;
    }

    int[] cache = new int[26];
    for (char c : text.toCharArray()) {
      cache[c - 'a']++;
    }

    int minSingle = Math.min(Math.min(cache['b' - 'a'], cache['a' - 'a']), cache['n' - 'a']);
    int minDouble = Math.min(cache['o' - 'a'], cache['l' - 'a']) / 2;
    return Math.min(minSingle, minDouble);
  }

  public static void main(String[] args) {
    String s = "nlaebolko";
    System.out.println(new Solution1189().maxNumberOfBalloons(s));
  }
}
