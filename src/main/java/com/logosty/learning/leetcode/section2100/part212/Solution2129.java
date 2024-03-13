package com.logosty.learning.leetcode.section2100.part212;

/**
 * @author logosty(ganyingle) on 2024/3/13 15:32
 * description: 2129. 将标题首字母大写 中等
 * 给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
 * <p>
 * 如果单词的长度为 1 或者 2 ，所有字母变成小写。
 * 否则，将单词首字母大写，剩余字母变成小写。
 * 请你返回 大写后 的 title 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：title = "capiTalIze tHe titLe"
 * 输出："Capitalize The Title"
 * 解释：
 * 由于所有单词的长度都至少为 3 ，将每个单词首字母大写，剩余字母变为小写。
 * 示例 2：
 * <p>
 * 输入：title = "First leTTeR of EACH Word"
 * 输出："First Letter of Each Word"
 * 解释：
 * 单词 "of" 长度为 2 ，所以它保持完全小写。
 * 其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
 * 示例 3：
 * <p>
 * 输入：title = "i lOve leetcode"
 * 输出："i Love Leetcode"
 * 解释：
 * 单词 "i" 长度为 1 ，所以它保留小写。
 * 其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= title.length <= 100
 * title 由单个空格隔开的单词组成，且不含有任何前导或后缀空格。
 * 每个单词由大写和小写英文字母组成，且都是 非空 的。
 */
public class Solution2129 {

    public String capitalizeTitle(String title) {
        char[] chars = new char[title.length()];
        if (title.length() <= 2) {
            for (int j = 0; j <= title.length(); j++) {
                char charAt = title.charAt(j);
                chars[j] = charAt < 'a' ? (char) (charAt + 32) : charAt;
            }
            return new String(chars);
        }


        int start = 0;
        int end = 0;

        for (int i = 1; i < title.length(); i++) {
            if (title.charAt(i) != ' ') {
                end++;
            } else {
                //全改成小写
                if (end - start <= 1) {
                    for (int j = start; j <= end; j++) {
                        char charAt = title.charAt(j);
                        chars[j] = charAt < 'a' ? (char) (charAt + 32) : charAt;
                    }
                } else {
                    //首字母大写
                    chars[start] = title.charAt(start) < 'a' ? title.charAt(start) : (char) (title.charAt(start) - 32);

                    for (int j = start + 1; j <= end; j++) {
                        char charAt = title.charAt(j);
                        chars[j] = charAt < 'a' ? (char) (charAt + 32) : charAt;
                    }
                }

                chars[i] = ' ';
                start = i + 1;
                end = i;
            }

            //全改成小写
            if (end - start <= 1) {
                for (int j = start; j <= end; j++) {
                    char charAt = title.charAt(j);
                    chars[j] = charAt < 'a' ? (char) (charAt + 32) : charAt;
                }
            } else {
                chars[i] = ' ';
                //首字母大写
                chars[start] = title.charAt(start) < 'a' ? title.charAt(start) : (char) (title.charAt(start) - 32);

                for (int j = start + 1; j <= end; j++) {
                    char charAt = title.charAt(j);
                    chars[j] = charAt < 'a' ? (char) (charAt + 32) : charAt;
                }
            }
        }


        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2129().capitalizeTitle("i lOve leetcode"));
    }
}
