package com.logosty.learning.test;

import com.alibaba.fastjson.JSON;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IDEA by @author:logosty(ganyingle)
 * Date:2018/12/17 Time:16:09
 * Description: 关于fastjson在线程池环境中内存泄漏的问题(内部使用threadlocal)
 * -Xms16m -Xmx16m -XX:+HeapDumpOnOutOfMemoryError
 */
public class FastJsonOOMTest implements Runnable {
    class Test{
        int a = 5;
        int b = 6;
        String c = "sfsdf";

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }

        public Test(int a) {
            this.a = a;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "a=" + a +
                    ", b=" + b +
                    ", c='" + c + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        for (int i = 0; i <= 100000; i++) {
            executorService.submit(new FastJsonOOMTest());
            if (i==100000) {
                System.out.println("end");
            }
        }
        long i = 1;
        while (true) {
            i++;
        }

    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        Test test = new Test(new Random().nextInt(100000));
        System.out.println(JSON.toJSON(test));
//        System.out.println(test);
    }



}
