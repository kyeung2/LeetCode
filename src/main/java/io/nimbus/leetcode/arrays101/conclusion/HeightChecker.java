package io.nimbus.leetcode.arrays101.conclusion;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3228/
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {

        //interesting that the Arrays.stream() version is slower, something to keep in mind
//        int[] sortedHeights = Arrays.stream(heights).sorted().toArray();
        int[] sortedHeights = new int[heights.length];
        System.arraycopy(heights, 0, sortedHeights, 0, heights.length);
        Arrays.sort(sortedHeights);

        int differences = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sortedHeights[i]) {
                differences++;
            }
        }

        return differences;
    }
}
