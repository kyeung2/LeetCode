package io.nimbus.leetcode.arrays101.search;

import java.util.*;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/
 */
public class SearchingForItemsInAnArray {

    // this implementation is faster.
    public boolean checkIfExist(int[] arr) {
        Set<Integer> visited = new HashSet<>();
        for (int i : arr) {
            if (!visited.add(i) && i == 0)
                return true; // we are returning true here, as a duplicate of 0's satisfies the N = 2 * M search criteria.
        }
        for (int i : arr) {
            if (i != 0 && visited.contains(i * 2))
                return true;
        }

        return false;
    }

    // I guess the creation of a stream, then the groupingBy collector is slow. Though good to have such a technique in
    // the pocket.
    public boolean checkIfExist_memory_usage_good_but_slow(int[] arr) {

        Map<Integer, Long> frequencies = Arrays.stream(arr).boxed().collect(groupingBy(
                identity(),
                HashMap::new,
                counting()
        ));

        if (frequencies.getOrDefault(0, 0L) > 1)
            return true;

        for (int i : arr) {
            if (i != 0 && frequencies.containsKey(i * 2))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SearchingForItemsInAnArray().checkIfExist(new int[]{7, 1, 14, 11}));
        System.out.println(new SearchingForItemsInAnArray().checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));
    }
}
