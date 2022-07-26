package com.logosty.learning.leetcode.section100.part11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ganyingle 
 * Created on 2022-07-18
 * 118. 杨辉三角 简单
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            list.add(1);
            if (i == 0) {
                res.add(list);
                continue;
            }
            if (i == 1) {
                list.add(1);
                res.add(list);
                continue;
            }

            List<Integer> last = res.get(i - 1);
            for (int i1 = 0; i1 < last.size() - 1; i1++) {
                list.add(last.get(i1) + last.get(i1 + 1));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
