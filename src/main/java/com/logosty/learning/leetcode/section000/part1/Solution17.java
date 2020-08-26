package com.logosty.learning.leetcode.section000.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author logosty(ganyingle) on 2020/8/26 15:43
 * 17. 电话号码的字母组合 中等
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Solution17 {

  private static Map<Character, List<Character>> map = new HashMap<>();

  static {
    map.put('2', List.of('a', 'b', 'c'));
    map.put('3', List.of('d', 'e', 'f'));
    map.put('4', List.of('g', 'h', 'i'));
    map.put('5', List.of('j', 'k', 'l'));
    map.put('6', List.of('m', 'n', 'o'));
    map.put('7', List.of('p', 'q', 'r', 's'));
    map.put('8', List.of('t', 'u', 'v'));
    map.put('9', List.of('w', 'x', 'y', 'z'));
  }


  /**
   * 执行用时：
   * 2 ms
   * , 在所有 Java 提交中击败了
   * 49.60%
   * 的用户
   * 内存消耗：
   * 38.8 MB
   * , 在所有 Java 提交中击败了
   * 46.33%
   * 的用户
   */
  public List<String> letterCombinations(String digits) {

    if (digits.length() == 0) {
      return new ArrayList<>();
    }
    char[] chars = digits.toCharArray();
    List<char[]> intArrayList = new ArrayList<>();
    intArrayList.add(new char[chars.length]);

    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      List<Character> list = map.get(c);
      int currentSize = intArrayList.size();
      for (int j = 0; j < currentSize; j++) {
        for (int k = 1; k < list.size(); k++) {
          char[] newArray = Arrays.copyOfRange(intArrayList.get(j), 0, intArrayList.get(j).length);
          newArray[i] = list.get(k);
          intArrayList.add(newArray);
        }
        intArrayList.get(j)[i] = list.get(0);
      }
    }
    return intArrayList.stream().map(String::valueOf).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    System.out.println(new Solution17().letterCombinations("23"));
  }
}
