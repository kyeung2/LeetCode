package io.nimbus.leetcode.queueandstack.conclusion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1387/
 */
public class ImplementingStackUsingQueue {



    // got this on my own, good. though calling some of the methods can break this implementation.
    // could be made more robust.
    static class MyStack {

        private final Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }


        // reversing the input makes the in the push() implementation makes the rest of the method implementations
        // much simpler. Probably can refactor the ImplementingQueueUsingStack to use the same idea.
        public void push(int x) {

            Queue<Integer> temp = new LinkedList<>();
            while (!queue.isEmpty())
                temp.offer(queue.poll());

            queue.offer(x);

            while (!temp.isEmpty())
                queue.offer(temp.poll());
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();

        }
    }

}
