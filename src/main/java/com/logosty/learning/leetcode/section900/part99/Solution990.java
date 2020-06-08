package com.logosty.learning.leetcode.section900.part99;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author logosty(ganyingle) on 2020/6/8 14:54
 * 990. 等式方程的可满足性 中等
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * 示例 2：
 *
 * 输出：["b==a","a==b"]
 * 输入：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * 示例 3：
 *
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 * 示例 4：
 *
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 * 示例 5：
 *
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] 和 equations[i][3] 是小写字母
 * equations[i][1] 要么是 '='，要么是 '!'
 * equations[i][2] 是 '='
 */
public class Solution990 {

  public boolean equationsPossible(String[] equations) {
    Map<Character, Variable> cache = new HashMap<>(equations.length);

    //挨个解析构造 ==
    for (int i = 0; i < equations.length; i++) {
      if (equations[i].charAt(1) != '=') {
        continue;
      }

      char a = equations[i].charAt(0);
      char b = equations[i].charAt(3);

      if (cache.containsKey(a) && cache.containsKey(b)) {
        if (!cache.get(a).equals(cache.get(b))) {
          int min = Math.min(cache.get(b).id, cache.get(a).id);
          cache.get(b).id = min;
          cache.get(a).id = min;
        }
        continue;
      }

      if (cache.containsKey(a)) {
        cache.put(b, cache.get(a));
        continue;
      }

      if (cache.containsKey(b)) {
        cache.put(a, cache.get(b));
        continue;
      }

      Variable variable = new Variable();
      cache.put(a, variable);
      cache.put(b, variable);
    }

    //挨个解析构造 !=
    for (int i = 0; i < equations.length; i++) {
      if (equations[i].charAt(1) == '=') {
        continue;
      }

      char a = equations[i].charAt(0);
      char b = equations[i].charAt(3);

      if (a == b) {
        return false;
      }

      if (cache.containsKey(a) && cache.containsKey(b)) {
        if (cache.get(a).equals(cache.get(b))) {
          return false;
        }
        continue;
      }

      if (cache.containsKey(a)) {
        cache.put(b, new Variable());
        continue;
      }

      if (cache.containsKey(b)) {
        cache.put(a, new Variable());
        continue;
      }

      cache.put(a, new Variable());
      cache.put(b, new Variable());

    }

    return true;
  }


  public static class Variable {

    public static int offset = 0;

    public int id;
    public Set<Variable> notSame;

    public Variable() {
      id = ++offset;
      notSame = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Variable variable = (Variable) o;
      return id == variable.id;
    }

    @Override
    public int hashCode() {
      return Objects.hash(id);
    }
  }

}
