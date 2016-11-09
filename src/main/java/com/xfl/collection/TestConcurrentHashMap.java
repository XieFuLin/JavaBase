package com.xfl.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by XFL
 * time on 2016/11/9 23:07
 * description:
 */
public class TestConcurrentHashMap {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(
                    "f(" + i + ") = " + fibonacci(i));
    }

    private static Map<Integer, Integer> cache = new HashMap<>();

    /*private static int fibonacci(int i) {
        if (i == 0)
            return i;

        if (i == 1)
            return 1;
        System.out.println("Calculating f(" + i + ")");
        return fibonacci(i - 2) + fibonacci(i - 1);
    }*/
    /*static int fibonacci(int i) {
        if (i == 0)
            return i;

        if (i == 1)
            return 1;

        return cache.computeIfAbsent(i, (key) ->
                fibonacci(i - 2)
                        + fibonacci(i - 1));
    }*/
    private static int fibonacci(int i) {
        if (i == 0)
            return i;

        if (i == 1)
            return 1;

        return cache.computeIfAbsent(i, (key) -> {
            System.out.println(
                    "Slow calculation of " + key);

            return fibonacci(i - 2) + fibonacci(i - 1);
        });
    }

    static int fibonacciJava7(int i) {
        if (i == 0)
            return i;

        if (i == 1)
            return 1;

        Integer result;
        result = cache.get(i);
        if (result == null) {
            synchronized (cache) {
                result = cache.get(i);

                if (result == null) {
                    System.out.println(
                            "Slow calculation of " + i);

                    result = fibonacci(i - 2)
                            + fibonacci(i - 1);
                    cache.put(i, result);
                }
            }
        }

        return result;
    }

}
