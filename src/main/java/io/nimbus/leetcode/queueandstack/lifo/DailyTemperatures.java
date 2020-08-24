package io.nimbus.leetcode.queueandstack.lifo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1363/
 */
public class DailyTemperatures {

    // solution from https://leetcode.com/problems/daily-temperatures/solution/
    // I couldn't think of something better than brute force.
    public int[] dailyTemperatures(int[] T) {

        int[] r = new int[T.length];

        // the stack represent indices
        Deque<Integer> indexStack = new ArrayDeque<>();


        for (int i = T.length - 1; i >= 0; i--) {

            // pop while coder than current.
            while (!indexStack.isEmpty() && T[i] >= T[indexStack.peek()])
                indexStack.pop();

            // top of indexStack is warmer
            // OR empty therefore NO warmer
            // number of days is the warmer day index - the current index
            r[i] = indexStack.isEmpty() ? 0 : indexStack.peek() - i;
            indexStack.push(i);
        }
        return r;
    }

    public static void main(String[] args) {

        int[] T = {73, 74, 75, 71, 69, 72, 76, 75};

        System.out.println(Arrays.toString(T));
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(T)));
    }
}
