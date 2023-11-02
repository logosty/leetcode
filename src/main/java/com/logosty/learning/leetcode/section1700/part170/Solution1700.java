package com.logosty.learning.leetcode.section1700.part170;

/**
 * 1700. 无法吃午餐的学生数量 简单
 * 0ms
 * 击败 100.00%使用 Java 的用户
 */
public class Solution1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int res = 0;
        int loopPos = 0;

        for (int sandwich : sandwiches) {
            boolean noOneMatch = true;
            for (int i = 0; i < students.length; i++) {
                int index = (loopPos + i) % students.length;

                //匹配上了
                if (students[index] == sandwich) {
                    noOneMatch = false;
                    students[index] = -1;
                    loopPos = (index + 1) % students.length;
                    break;
                }

                //没匹配上或者没空位了
            }

            if (noOneMatch) {
                break;
            }
        }

        for (int student : students) {
            if (student >= 0) {
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] students = {1,1,1,0,0,1};


        int[] sandwiches = {1,0,0,0,1,1};
        System.out.println(new Solution1700().countStudents(students, sandwiches));

    }
}
