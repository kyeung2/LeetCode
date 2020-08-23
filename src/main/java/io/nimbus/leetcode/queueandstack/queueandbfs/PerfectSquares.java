package io.nimbus.leetcode.queueandstack.queueandbfs;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1371/
 */
public class PerfectSquares {

    // very smart solution found at: https://www.youtube.com/watch?v=1xfx6M_GqFk

    public int solve_recursive_no_DP(int n) {
        // in these small cases, it will be using 1^2 + 1^2 etc.
        if (n <= 3) return n;
        int res = n; // worst case would be 1^2 * n times.
        // this creates each perfect square break points
        for (int i = 1; i * i < n; i++) {
            res = Math.min(res, 1 + solve_recursive_no_DP(n - i * i));
        }
        return res;
    }

    public int solve(int n) {
        // lookup table with previous results.
        Map<Integer, Integer> dp = new HashMap<>();
        return solve(n, dp);
    }

    public int solve(int n, Map<Integer, Integer> dp) {
        // in these small cases, it will be using 1^2 + 1^2 etc.
        if (n <= 3) return n;
        if (dp.containsKey(n)) return dp.get(n);
        int steps = n; // worst case would be 1^2 * n times.

        // this creates each perfect square break points
        for (int i = 1; i * i <= n; ++i) {
            steps = Math.min(steps, 1 + solve(n - i * i, dp));
        }
        dp.put(n, steps);
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().solve(12));
    }


}
