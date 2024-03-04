package com.logosty.learning.leetcode.section100.part13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author logosty(ganyingle) on 2024/3/4 17:14
 * description: 139. 单词拆分 中等
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅由小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 */
public class Solution139 {
    Map<String, Boolean> cache = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        for (String word : wordDict) {
            //前缀不匹配，直接跳过
            if (!match(s, word)) {
                continue;
            }

            if (word.length() == s.length()) {
                cache.put(s, true);
                return true;
            }

            if (wordBreak(s.substring(word.length()), wordDict)) {
                cache.put(s, true);
                return true;
            }
        }
        cache.put(s, false);
        return false;
    }

    private boolean match(String s, String word) {
        if (word.length() > s.length()) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != s.charAt(i)) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String s = "leetcode";

        String[] words = new String[] {"leet", "code"};
        List<String> collect = Arrays.stream(words).collect(Collectors.toList());
        System.out.println(new Solution139().wordBreak(s, collect));
    }
}
