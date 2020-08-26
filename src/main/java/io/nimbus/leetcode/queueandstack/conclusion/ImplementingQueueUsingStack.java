package io.nimbus.leetcode.queueandstack.conclusion;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1386/
 */
public class ImplementingQueueUsingStack {


    // got this on my own, good.
    static class MyQueue {

        private final Deque<Integer> stack;

        public MyQueue() {
            stack = new ArrayDeque<>();
        }

        public void push(int x) {
            stack.push(x);
        }

        public int pop() {

            Deque<Integer> temp = new ArrayDeque<>();
            while (!stack.isEmpty())
                temp.push(stack.pop());

            int topValue = temp.pop();

            while (!temp.isEmpty())
                stack.push(temp.pop());

            return topValue;
        }

        public int peek() {
            return stack.peekLast();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }


    public static void main(String[] args) {

        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println( queue.peek());  // returns 1
        System.out.println(   queue.pop());   // returns 1
        queue.empty(); // returns false
    }
}
