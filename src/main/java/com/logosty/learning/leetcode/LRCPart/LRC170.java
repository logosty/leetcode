package com.logosty.learning.leetcode.LRCPart;

/**
 * LCR 170. 交易逆序对的总数 困难
 * 在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。请设计一个程序，输入一段时间内的股票交易记录 record，返回其中存在的「交易逆序对」总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入：record = [9, 7, 5, 4, 6]
 * 输出：8
 * 解释：交易中的逆序对为 (9, 7), (9, 5), (9, 4), (9, 6), (7, 5), (7, 4), (7, 6), (5, 4)。
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= record.length <= 50000
 * <p>
 * <p>
 * 时间
 * 详情
 * 31ms
 * 击败 79.54%使用 Java 的用户
 */
public class LRC170 {
    public int reversePairs(int[] record) {
        if (record.length <= 1) {
            return 0;
        }
        return process(record, 0, record.length - 1);
    }

    private int process(int[] record, int left, int right) {
        //只有一个数就不需要做什么了
        if (left == right) {
            return 0;
        }

        //middle 属于左边
        int middle = left + (right - left) / 2;

        return process(record, left, middle)
                + process(record, middle + 1, right)
                + mergeAndCal(record, left, right, middle);
    }

    private int mergeAndCal(int[] record, int left, int right, int middle) {
        int[] helpArray = new int[right - left + 1];
        int res = 0;

        int helpArrayIndex = 0;
        int leftIndex = left;
        int rightIndex = middle + 1;

        //一直遍历直到某一个越界
        while (leftIndex <= middle && rightIndex <= right) {
            // 左边小于或者等于右边，就取左边
            if (record[leftIndex] <= record[rightIndex]) {
                helpArray[helpArrayIndex++] = record[leftIndex++];
                continue;
            }

            //右边小，就取右边，并且统计左边还剩多少个数
            helpArray[helpArrayIndex++] = record[rightIndex++];
            res += middle - leftIndex + 1;
        }

        //将剩下的填充即可
        while (leftIndex <= middle) {
            helpArray[helpArrayIndex++] = record[leftIndex++];
        }
        while (rightIndex <= right) {
            helpArray[helpArrayIndex++] = record[rightIndex++];
        }

        //然后把数组覆盖原数组
        for (int i = 0; i < helpArray.length; i++) {
            record[left + i] = helpArray[i];
        }

        return res;
    }


    public static void main(String[] args) {
        int[] array = new int[] {9, 7, 5, 4, 6};
        System.out.println(new LRC170().reversePairs(array));
    }
}
