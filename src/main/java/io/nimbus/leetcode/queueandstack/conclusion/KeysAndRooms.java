package io.nimbus.leetcode.queueandstack.conclusion;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1391/
 */
public class KeysAndRooms {

    // pretty happy I got this on my own. Needed to keep a Set of visited rooms to not go into an
    // infinite loop. bfs used to traverse the rooms/ nodes and edges.

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Deque<Integer> keys = new ArrayDeque<>();
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
