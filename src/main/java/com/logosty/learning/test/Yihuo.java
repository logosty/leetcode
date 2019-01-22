package com.logosty.learning.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IDEA by @author:logosty(ganyingle)
 * Date:2018/12/27 Time:20:14
 * Description:
 */
public class Yihuo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Collections.singletonList("f"));
        list.add("m");
        list.add("f");

        list.forEach(x->{
            System.out.println();
            System.out.println((int) x.charAt(0) + "->" + (x.charAt(0) ^ 'f' ^ 'm'));
        });

    }
}
