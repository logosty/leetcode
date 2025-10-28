package com.logosty.learning.leetcode.section400.part44;

/**
 * @author logosty(ganyingle) on 2025/10/24 15:46
 * description: 443. 压缩字符串 中等
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 * <p>
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 * <p>
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 * <p>
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 * <p>
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 * <p>
 * 注意：数组中超出返回长度的字符无关紧要，应予忽略。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：chars = ["a","a","b","b","c","c","c"]
 * 输出：返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
 * 解释："aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
 * 示例 2：
 * <p>
 * 输入：chars = ["a"]
 * 输出：返回 1 ，输入数组的前 1 个字符应该是：["a"]
 * 解释：唯一的组是“a”，它保持未压缩，因为它是一个字符。
 * 示例 3：
 * <p>
 * 输入：chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：返回 4 ，输入数组的前 4 个字符应该是：["a","b","1","2"]。
 * 解释：由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= chars.length <= 2000
 * chars[i] 可以是小写英文字母、大写英文字母、数字或符号
 */
public class Solution443 {
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }

        int writePointer = 0;   //上一个写入的位置
        int readPointer = 1;    //当前读取的位置
        int count = 1;

        for (; readPointer < chars.length; readPointer++) {
            if (chars[readPointer] == chars[writePointer]) {
                count++;
                continue;
            }

            writePointer = writeCount(count, chars, writePointer, readPointer);

            chars[++writePointer] = chars[readPointer];
            count = 1;
        }

        writePointer = writeCount(count, chars, writePointer, readPointer - 1);

        return writePointer + 1;
    }

    //返回最后写入的位置writePointer
    private int writeCount(int count, char[] chars, int writePointer, int readPointer) {
        if (count == 1) {
            //            chars[++writePointer] = chars[readPointer];
            return writePointer;
        }

        // 计算数字的位数
        int temp = count;
        int digitCount = 0;
        while (temp > 0) {
            digitCount++;
            temp /= 10;
        }
        // 从最低位开始填充字符数组
        for (int i = writePointer + digitCount; i >= writePointer + 1; i--) {
            int digit = count % 10;      // 获取最后一位数字
            chars[i] = (char) ('0' + digit); // 转换为字符
            count /= 10;                 // 移除最后一位数字
        }

        return writePointer + digitCount;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'a', 'a', 'a', 'b'};
        System.out.println(new Solution443().compress(chars));
    }
}
