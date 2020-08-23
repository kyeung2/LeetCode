package io.nimbus.leetcode.queueandstack.queueandbfs;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1375/
 */
public class OpenTheLock {


    // didn't get anywhere with this one. I tried to change the input type into
    // a numeric list. Too much work, fighting against the input of the task.
    // should assume there are not trying to be that difficult.

    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");

        int moves = 0;
        while (!queue.isEmpty()) {

           int s =  queue.size();
            for (int i = 0; i < s; i++) {

                String combo = queue.poll();
                if (target.equals(combo)) return moves;
                if (deads.contains(combo)) continue;

                StringBuilder b = new StringBuilder(combo);
                // try each digit, for each digit plus and minus, looping.
                for (int j = 0; j < 4; j++) {
                    char digit = b.charAt(j);
                    String plus = b.substring(0, j) + (digit == '9' ? 0 : digit - '0' + 1) + b.substring(j + 1);
                    String minus = b.substring(0, j) + (digit == '0' ? 9 : digit - '0' - 1) + b.substring(j + 1);

                    if (!visited.contains(plus) && !deads.contains(plus)) {
                        queue.offer(plus);
                        visited.add(plus);
                    }
                    if (!visited.contains(minus) && !deads.contains(minus)) {
                        queue.offer(minus);
                        visited.add(minus);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    public static void main(String[] args) {


    }


    /**
     1. if the source is a DE cannot reach target so the DE are filters.
     de: 0000
     0000 -> cannot reach target

     2. 0000 -> there are 8 possible moves per iteration:
     - 0001,
     - 0010,
     - 0100,
     - 1000,
     - 0009,
     - 0090,
     - 0900,
     - 9000
     3. from each iteration need to check if target is reached and also
     not filtered and also not previously visited.

     */


}
