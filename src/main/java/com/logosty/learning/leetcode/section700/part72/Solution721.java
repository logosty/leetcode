package com.logosty.learning.leetcode.section700.part72;

import com.alibaba.fastjson.JSON;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author logosty(ganyingle) on 2021/1/18 10:27
 * 721. 账户合并 中等
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，
 * 其余元素是 emails 表示该账户的邮箱地址。
 *
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。
 * 请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 *
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 *
 *
 * 提示：
 *
 * accounts的长度将在[1，1000]的范围内。
 * accounts[i]的长度将在[1，10]的范围内。
 * accounts[i][j]的长度将在[1，30]的范围内。
 *
 * [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 */
public class Solution721 {

  public static void main(String[] args) {
    List<List<String>> list = List
        .of(List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
            List.of("John", "johnsmith@mail.com", "john00@mail.com"),
            List.of("Mary", "mary@mail.com"),
            List.of("John", "johnnybravo@mail.com"));

    System.out.println(JSON.toJSONString(new Solution721().accountsMerge(list)));
  }

  /**
   * 执行用时：
   * 48 ms
   * , 在所有 Java 提交中击败了
   * 41.40%
   * 的用户
   * 内存消耗：
   * 43.6 MB
   * , 在所有 Java 提交中击败了
   * 27.04%
   * 的用户
   * @param accounts
   * @return
   */
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, Integer> map = new HashMap<>();
    UnionFind unionFind = new UnionFind(accounts.size());

    for (int i = 0; i < accounts.size(); i++) {
      List<String> list = accounts.get(i);
      for (int j = 1; j < list.size(); j++) {
        String email = list.get(j);
        Integer integer = map.get(email);
        if (integer == null) {
          map.put(email, i);
        } else {
          map.put(email, integer);
          unionFind.merge(i, integer);
        }
      }
    }
    List<List<String>> collect = IntStream.range(0, unionFind.parents.length)
        .boxed()
        .collect(Collectors.groupingBy(unionFind::getParent))
        .values().stream()
        .map(integers -> integers.stream()
            .map(accounts::get)
            .flatMap(Collection::stream)
            .distinct()
            .sorted()
            .collect(Collectors.toList()))
        .collect(Collectors.toList());

    return collect;
  }

  static class UnionFind {

    int[] parents;
    int[] levels;

    public UnionFind(int size) {
      parents = new int[size];
      for (int i = 0; i < parents.length; i++) {
        parents[i] = i;
      }
      levels = new int[size];
      Arrays.fill(levels, 1);
    }

    public void merge(int i, int j) {
      int parent1 = getParent(i);
      int parent2 = getParent(j);
      if (parent1 == parent2) {
        return;
      }

      if (levels[i] >= levels[j]) {
        parents[parent2] = parent1;
        levels[j]++;
      } else {
        parents[parent1] = parent2;
        levels[i]++;
      }
    }

    public int getParent(int i) {
      while (parents[i] != i) {
        i = parents[i];
      }
      return parents[i];
    }


  }
}
