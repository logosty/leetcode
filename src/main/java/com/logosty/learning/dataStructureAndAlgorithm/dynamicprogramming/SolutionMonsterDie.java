package com.logosty.learning.dataStructureAndAlgorithm.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author logosty(ganyingle) on 2024/2/29 15:43
 * description: 怪兽砍一刀
 * 给定3个参数，N，M，K 怪兽有N滴血，等着英雄来砍自己
 * 英雄每一次打击，都会让怪兽流失[0-M]的血量
 * <p>
 * 到底流失多少?每一次在[0~M]上等概率的获得一个值
 * 求K次打击之后，英雄把怪兽砍死的概率
 */
public class SolutionMonsterDie {
    private Map<String, Long> cache = new HashMap<>();

    public long monsterDie(int time, int M, int hp) {
        long ways = monsterDieWays(time, M, hp);
        return ways;
    }

    public long monsterDieWays(int time, int M, int hp) {
        //没次数了
        if (time == 0) {
            return hp <= 0 ? 1 : 0;
        }

        //没血了
        if (hp <= 0) {
            return (int) Math.pow(M + 1, time);
        }

        String key = time + "_" + hp;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        long ways = 0;
        for (int i = 0; i <= M; i++) {
            ways += monsterDieWays(time - 1, M, hp - i);
        }

        cache.put(key, ways);
        return ways;
    }


    /**
     * 纯转dp，无优化
     */
    public long dp(int time, int M, int hp) {
        long[][] dp = new long[time + 1][hp + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= time; i++) {
            for (int j = 0; j <= hp; j++) {
                long thisWays = 0;
                for (int k = 0; k <= M && j - k >= 0; k++) {
                    thisWays += dp[i - 1][j - k];
                }

                dp[i][j] = thisWays;
            }
        }
        return dp[time][hp];
    }

    /**
     * 纯转dp，优化掉一个循环
     * 使用前置格子数据
     */
    public long dp2(int time, int M, int hp) {
        long[][] dp = new long[time + 1][hp + 1];
        for (int i = 0; i <= time; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= time; i++) {
            for (int j = 1; j <= hp; j++) {
                long thisWays = dp[i - 1][j];

                //前面的数已经计算过一遍了
                thisWays += dp[i][j - 1];
                //去掉重复多计算的
                if (j - M - 1 >= 0) {
                    thisWays -= dp[i - 1][j - M - 1];
                }

                dp[i][j] = thisWays;
            }
        }
        return dp[time][hp];
    }

    public static void main(String[] args) {
        int time = 3;
        int M = 10;
        int hp = 20;
        long total = (long) Math.pow(M + 1, time);

        System.out.println(new SolutionMonsterDie().monsterDie(time, M, hp));
        System.out.println(new SolutionMonsterDie().dp(time, M, hp));
        System.out.println(new SolutionMonsterDie().dp2(time, M, hp));

    }
}
