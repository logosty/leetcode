package com.logosty.learning.leetcode.section700.part70;

/**
 * @author logosty(ganyingle) on 2024/4/15 11:23
 * description: 706. 设计哈希映射 简单
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * <p>
 * 实现 MyHashMap 类：
 * <p>
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * 输出：
 * [null, null, null, 1, -1, null, 1, null, -1]
 * <p>
 * 解释：
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 * myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 * myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 * myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 * myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= key, value <= 106
 * 最多调用 104 次 put、get 和 remove 方法
 */
public class Solution706 {
    class MyHashSet {

        int[] cache;
        boolean[] exist;

        public MyHashSet() {
            cache = new int[(int) (1e6 + 1)];
            exist = new boolean[(int) (1e6 + 1)];
        }

        public void put(int key, int value) {
            cache[key] = value;
            exist[key] = true;

        }

        public int get(int key) {
            if (!exist[key]) {
                return -1;
            }

            return cache[key];
        }

        public void remove(int key) {
            exist[key] = false;
            cache[key] = -1;
        }
    }
}
