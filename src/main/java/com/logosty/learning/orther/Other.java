package com.logosty.learning.orther;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA by logosty
 * Date:2019/4/12 Time:16:13
 * Description:
 */
public class Other {
    private static final Logger logger = LoggerFactory.getLogger(Other.class);

    /**
     * 计算1!+2!+3!+..+n!
     */
//    迭代
    public int getFactorial(int n) {
        int cur = 1;
        int count = 1;

        for (int i = 2; i <= n; i++) {
            cur *= i;
            count += cur;
        }

        return count;
    }

    private Map<Integer, Integer> cache = new HashMap<>();
//    递归
    public int getFactorial1(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += loop(i, 1);
        }
        return count;
    }

    private int loop(int i, int lastCount) {
        if (i == 1) {
            return lastCount;
        }
        if (cache.get(i) != null) {
            return cache.get(i) * lastCount;
        }

        int result = loop(i - 1, lastCount * i);
        cache.put(i, result);
        return result;
    }


    public static void main(String[] args) {
        int n = 300000;
        StopWatch stopWatch = new StopWatch();

        stopWatch.start("getFactorial");
        System.out.println(new Other().getFactorial(n));
        stopWatch.stop();
        logger.info("{} cost {}", stopWatch.getLastTaskName(), stopWatch.getLastTaskTimeMillis());

        stopWatch.start("getFactorial1");
        System.out.println(new Other().getFactorial1(n));
        stopWatch.stop();
        logger.info("{} cost {}", stopWatch.getLastTaskName(), stopWatch.getLastTaskTimeMillis());
    }
}
