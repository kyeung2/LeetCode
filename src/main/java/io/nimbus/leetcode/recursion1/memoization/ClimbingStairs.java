package io.nimbus.leetcode.recursion1.memoization;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1662/
 */
public class ClimbingStairs {


    // looking at the actual combinations it isn't so intuitive, but looking at the results
    // 0,1,2,3,5,8 you can clearly see it is fib.
    public int climbStairs(int n) {
        return _climbStairs(n, new HashMap<>());
    }

    public int _climbStairs(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) return cache.get(n);
        int result;
        if (n < 3) result = n;
        else result = _climbStairs(n - 1, cache) + _climbStairs(n - 2, cache);
        cache.put(n, result);
        return result;
    }

    public static void main(String[] args) {

        ClimbingStairs climbingStairs = new ClimbingStairs();
        for (int i = 0; i < 10; i++) {
            System.out.println(climbingStairs.climbStairs(i));
        }
    }
}
