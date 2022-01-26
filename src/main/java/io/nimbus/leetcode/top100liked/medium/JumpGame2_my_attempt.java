package io.nimbus.leetcode.top100liked.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGame2_my_attempt {


    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new JumpGame2_my_attempt().jump(nums));
    }

    public int jump(int[] nums) {

        /**
         * TODO: from the description I can think of the following
         *
         * 1. the order of nums is important to the question so no sorting of that.
         * 2. the algo needs keep the current best minimumJumps score. defaulting to size-1.
         * 3. the algo should shortcut going through the rest of the array if current minimumJumps < currentIndex + 1
         * 4. feels like a backtracking algo. e.g. index 0 = 2, so try 1 and 2 from that, meaning you will get to index 2 = 1...
         *
         * TODO I think my solution works but a total over engineered wrong approach.
         */

        List<Integer> steps = new ArrayList<>();
        steps.add(Integer.MAX_VALUE);
        backtrack(nums, 0, 0, steps);

        return steps.stream().min(Comparator.naturalOrder()).get();
    }

    void backtrack(int[] nums, int currentIndex, int stepsTaken, List<Integer> steps) {

        if (currentIndex >= nums.length - 1) {
            steps.add(stepsTaken);
            return;
        }

        // so a little shortcut here.. dont go into this if its already more moves than needed.
        if (stepsTaken + 1 < steps.stream().min(Comparator.naturalOrder()).get()) {

            for (int move = nums[currentIndex]; move > 0; move--) {
                currentIndex += move;

                //TODO no point continuing the search if stepsTaken+1 is more than the current best.
                backtrack(nums, currentIndex, stepsTaken + 1, steps);
                // only back track if this "path" was greater than
                currentIndex -= move;
            }
        }
    }
}
