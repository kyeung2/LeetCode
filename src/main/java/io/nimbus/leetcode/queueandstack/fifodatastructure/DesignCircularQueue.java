package io.nimbus.leetcode.queueandstack.fifodatastructure;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1337/
 */
public class DesignCircularQueue {


    // pretty happy with the implementation, exactly as how i designed nothing really going wrong with the implementation.
    // initially i missed tail = (tail + 1) % data.length; and wrote tail = tail + 1 % data.length; Need to be careful
    // when writing the logic.
    static class MyCircularQueue {

        private int head = -1;
        private int tail = -1;
        private final int[] data;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            data = new int[k];
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {

            if (isFull())
                return false;

            // if empty
            if (isEmpty()) {
                head = 0;
            }

            // normal situation. we modulo size to loop back round.
            tail = (tail + 1) % data.length;
            data[tail] = value;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {

            if (isEmpty())
                return false;

            data[head] = 0;// should I use 0 as null value?
            if (head == tail) {// if head and tail was at same location then now becomes empty.
                head = -1;
                tail = -1;
            } else
                head = (head + 1) % data.length;

            return true;

        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            return isEmpty() ? -1 : data[head];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            return isEmpty() ? -1 : data[tail];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return head == -1 && tail == -1;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return ((tail + 1) % data.length) == head;
        }
    }


    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(5);

        boolean isEmpty = queue.isEmpty();
        queue.enQueue(5);
        queue.enQueue(13);
        queue.enQueue(8);
        queue.enQueue(2);
        queue.enQueue(10);
        queue.deQueue();
        queue.deQueue();
        queue.enQueue(23);
        queue.enQueue(6);
        boolean isFull = queue.isFull();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        boolean isEmpty2 = queue.isEmpty();
        System.out.println();
    }
}
