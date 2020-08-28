package io.nimbus.leetcode.recursion1.memoization;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1661/
 */
public class FibonacciNumber {

    public int fib(int N) {
        // not sure if this state should last beyond the lifetime of the function call or not
        // this way I have a pure function.
        Map<Integer, Integer> cache = new HashMap<>();
        return _fib(N, cache);
    }

    public int _fib(int N, Map<Integer, Integer> cache) {
        if (cache.containsKey(N)) cache.get(N);
        int result;
        if (N < 2) result = N;
        else
            result = _fib(N - 1, cache) + _fib(N - 2, cache);
        cache.put(N, result);

        return result;
    }

    public static void main(String[] args) {

        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacciNumber.fib(i));
        }
    }
}
