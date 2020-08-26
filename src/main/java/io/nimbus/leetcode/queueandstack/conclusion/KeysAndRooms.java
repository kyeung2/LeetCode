package io.nimbus.leetcode.queueandstack.conclusion;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1391/
 */
public class KeysAndRooms {

    // pretty happy I got this on my own. Needed to keep a Set of visited rooms to not go into an
    // infinite loop. bfs used to traverse the rooms/ nodes and edges.

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {


        // the solution also used a dfs, which is more appropriate as you are not visiting neighbours
        // but guided by the keys to the next iteration.
        Deque<Integer> keys = new ArrayDeque<>();

        // the solution on the site used a boolean[] visited, uses less space than my solution.
        Set<Integer> visitedRooms = new HashSet<>();

        // initially room 0 is unlocked.
        rooms.get(0).forEach(keys::offer);
        visitedRooms.add(0);

        // bfs the rooms
        while (!keys.isEmpty()) {
            int key = keys.pop();
            visitedRooms.add(key);
            for (Integer newKey : rooms.get(key)) {
                if (!visitedRooms.contains(newKey)) {
                    keys.offer(newKey);
                }
            }
        }

        for (int i = 1; i < rooms.size(); i++)
            if (!visitedRooms.contains(i))
                return false;

        return true;
    }

}
