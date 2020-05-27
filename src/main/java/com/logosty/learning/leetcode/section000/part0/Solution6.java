package com.logosty.learning.leetcode.section000.part0;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA by logosty
 * Date:2018/11/13 Time:19:14
 * Description: Z字型变换 中等
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 * 示例 :
 * 输入: s = "PAYPALISHIRING", numRows = 4
 * 输出: "PINALSIGYAHRPI"
 * 解释:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() < 1) {
            return s;
        }
        List<StringBuilder> retList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            retList.add(new StringBuilder());
        }

        boolean isDown = true;
        int rowOffset = 0;
        for (int i = 0; i < s.length(); i++) {
            retList.get(rowOffset).append(s.charAt(i));

            if (rowOffset == numRows - 1 || (rowOffset != 0 && !isDown)) {
                isDown = false;
                rowOffset--;
                continue;
            }

            isDown = true;
            rowOffset++;
        }

        StringBuilder retSb = new StringBuilder();
        for (int i = 0; i < retList.size(); i++) {
            retSb.append(retList.get(i));
        }

        return retSb.toString();
    }

    public void addToList(List<StringBuilder> retList, int listOffset, int numRows, String s, int stringOffset, boolean isDown) {
        if (s.length() <= stringOffset) {
            return;
        }
        retList.get(listOffset).append(s.charAt(stringOffset));
        if (listOffset == 0) {
            addToList(retList, listOffset + 1, numRows, s, stringOffset + 1, true);
            return;
        }
        if (listOffset == numRows - 1) {
            addToList(retList, listOffset - 1, numRows, s, stringOffset + 1, false);
            return;
        }
        if (isDown) {
            addToList(retList, listOffset + 1, numRows, s, stringOffset + 1, isDown);
            return;
        }
        addToList(retList, listOffset - 1, numRows, s, stringOffset + 1, isDown);
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        String s = "PAYPALISHIRING";
        System.out.println(new Solution6().convert(s, 4));
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - begin));
    }
}
