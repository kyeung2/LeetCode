package io.nimbus.leetcode.queueandstack.lifo;

import java.util.Stack;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1360/
 */
public class MinStack {

    private final Stack<Integer> data = new Stack<>();
    private final Stack<Integer> min = new Stack<>();

    public void push(int x) {
        data.push(x);
        if (min.isEmpty() || x <= min.peek())
            min.push(x);
    }

    public void pop() {
        if (data.pop().equals(min.peek()))
            min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
