package com.logosty.learning.leetcode.section2600.part267;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author logosty(ganyingle) on 2024/3/21 15:07
 * description: 2671. 频率跟踪器 中等
 * 请你设计并实现一个能够对其中的值进行跟踪的数据结构，并支持对频率相关查询进行应答。
 * <p>
 * 实现 FrequencyTracker 类：
 * <p>
 * FrequencyTracker()：使用一个空数组初始化 FrequencyTracker 对象。
 * void add(int number)：添加一个 number 到数据结构中。
 * void deleteOne(int number)：从数据结构中删除一个 number 。数据结构 可能不包含 number ，在这种情况下不删除任何内容。
 * bool hasFrequency(int frequency): 如果数据结构中存在出现 frequency 次的数字，则返回 true，否则返回 false。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["FrequencyTracker", "add", "add", "hasFrequency"]
 * [[], [3], [3], [2]]
 * 输出
 * [null, null, null, true]
 * <p>
 * 解释
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.add(3); // 数据结构现在包含 [3]
 * frequencyTracker.add(3); // 数据结构现在包含 [3, 3]
 * frequencyTracker.hasFrequency(2); // 返回 true ，因为 3 出现 2 次
 * 示例 2：
 * <p>
 * 输入
 * ["FrequencyTracker", "add", "deleteOne", "hasFrequency"]
 * [[], [1], [1], [1]]
 * 输出
 * [null, null, null, false]
 * <p>
 * 解释
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.add(1); // 数据结构现在包含 [1]
 * frequencyTracker.deleteOne(1); // 数据结构现在为空 []
 * frequencyTracker.hasFrequency(1); // 返回 false ，因为数据结构为空
 * 示例 3：
 * <p>
 * 输入
 * ["FrequencyTracker", "hasFrequency", "add", "hasFrequency"]
 * [[], [2], [3], [1]]
 * 输出
 * [null, false, null, true]
 * <p>
 * 解释
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.hasFrequency(2); // 返回 false ，因为数据结构为空
 * frequencyTracker.add(3); // 数据结构现在包含 [3]
 * frequencyTracker.hasFrequency(1); // 返回 true ，因为 3 出现 1 次
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= number <= 105
 * 1 <= frequency <= 105
 * 最多调用 add、deleteOne 和 hasFrequency 共计 2 * 105 次
 * /**
 * * Your FrequencyTracker object will be instantiated and called as such:
 * * FrequencyTracker obj = new FrequencyTracker();
 * * obj.add(number);
 * * obj.deleteOne(number);
 * * boolean param_3 = obj.hasFrequency(frequency);
 */
public class Solution2671 {
    class FrequencyTracker {
        Map<Integer, Integer> num2Frequency;
        Map<Integer, Set<Integer>> frequency2Num;

        public FrequencyTracker() {
            num2Frequency = new HashMap<>();
            frequency2Num = new HashMap<>();
        }


        //删除原来的数字到频率的映射
        //删除原来的频率的数字
        //增加新数字的频率映射
        //增加新的频率到数字
        public void add(int number) {
            modNum(number, true);
        }

        public void deleteOne(int number) {
            modNum(number, false);
        }

        private void modNum(int number, boolean doAdd) {
            int frequencyOld = num2Frequency.getOrDefault(number, 0);
            num2Frequency.remove(number);

            Set<Integer> frequency2NumOld = frequency2Num.getOrDefault(frequencyOld, Collections.emptySet());
            frequency2NumOld.remove(number);

            int frequencyNew = doAdd ? frequencyOld + 1 : frequencyOld - 1;
            if (!doAdd && frequencyNew <= 0) {
                return;
            }

            num2Frequency.put(number, frequencyNew);

            Set<Integer> frequency2NumNew = frequency2Num.getOrDefault(frequencyNew, new HashSet<>());
            frequency2NumNew.add(number);
            frequency2Num.put(frequencyNew, frequency2NumNew);
        }

        public boolean hasFrequency(int frequency) {
            return !frequency2Num.getOrDefault(frequency, Collections.emptySet()).isEmpty();
        }

    }
}
