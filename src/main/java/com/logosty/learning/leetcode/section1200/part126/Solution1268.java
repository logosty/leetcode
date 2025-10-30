package com.logosty.learning.leetcode.section1200.part126;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

/**
 * @author logosty(ganyingle) on 2025/10/30 10:48
 * description: 1268. 搜索推荐系统 中等
 * 给你一个产品数组 products 和一个字符串 searchWord ，products  数组中每个产品都是一个字符串。
 * <p>
 * 请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，推荐 products 数组中前缀与 searchWord 相同的最多三个产品。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
 * <p>
 * 请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * 输出：[
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * 解释：按字典序排序后的产品列表是 ["mobile","moneypot","monitor","mouse","mousepad"]
 * 输入 m 和 mo，由于所有产品的前缀都相同，所以系统返回字典序最小的三个产品 ["mobile","moneypot","monitor"]
 * 输入 mou， mous 和 mouse 后系统都返回 ["mouse","mousepad"]
 * 示例 2：
 * <p>
 * 输入：products = ["havana"], searchWord = "havana"
 * 输出：[["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * 示例 3：
 * <p>
 * 输入：products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 * 输出：[["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 * 示例 4：
 * <p>
 * 输入：products = ["havana"], searchWord = "tatiana"
 * 输出：[[],[],[],[],[],[],[]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= products.length <= 1000
 * 1 <= Σ products[i].length <= 2 * 10^4
 * products[i] 中所有的字符都是小写英文字母。
 * 1 <= searchWord.length <= 1000
 * searchWord 中所有字符都是小写英文字母。
 */
public class Solution1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        //录入字典
        Node[] homePage = new Node[26];
        for (String product : products) {
            record(homePage, product);
        }

        //搜索返回
        return serach(homePage, searchWord);
    }

    private void record(Node[] homePage, String word) {
        Node pre = null;
        Node[] curPage = homePage;
        for (char c : word.toCharArray()) {
            Node node = curPage[c - 'a'];
            if (node == null) {
                node = new Node(c);

                if (pre == null) { //首页
                    homePage[c - 'a'] = node;
                } else {
                    pre.nextPage[c - 'a'] = node;
                    node.prev = pre;
                }
            }
            pre = node;
            curPage = pre.nextPage;
        }
        while (pre != null) {
            if (pre.recommendWords == null) {
                pre.recommendWords = new ArrayList<>();
            }
            pre.recommendWords.add(word);
            pre.recommendWords = pre.recommendWords.stream().sorted().limit(3).collect(Collectors.toList());
            pre = pre.prev;
        }
    }

    private List<List<String>> serach(Node[] homePage, String searchWord) {
        Node[] curPage = homePage;
        List<List<String>> result = new ArrayList<>();
        List<String> lastRecommend = new ArrayList<>();

        for (char c : searchWord.toCharArray()) {
            //使用上级推荐
            if (curPage == null || curPage[c - 'a'] == null) {
                result.add(lastRecommend);
                curPage = null;
                continue;
            }
            Node curNode = curPage[c - 'a'];

            result.add(curNode.recommendWords);
            curPage = curNode.nextPage;
        }


        return result;
    }


    class Node {
        char curChar;
        Node[] nextPage = new Node[26];
        Node prev = null;
        List<String> recommendWords = new ArrayList<String>();

        public Node(char curChar) {
            this.curChar = curChar;
        }
    }

    public static void main(String[] args) {
        List<List<String>> mouse = new Solution1268().suggestedProducts(
                new String[] {"bags", "baggage", "banner", "box", "cloths"}, "bags");
        System.out.println(JSON.toJSON(mouse));

    }
}
