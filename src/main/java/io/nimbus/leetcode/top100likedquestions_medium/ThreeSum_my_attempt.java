package io.nimbus.leetcode.top100likedquestions_medium;

import java.util.*;

public class ThreeSum_my_attempt {

    private static final int TARGET_SUM = 0;

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        var myAttempt = new ThreeSum_my_attempt();
        System.out.println(myAttempt.threeSum_brute_force(nums));
        System.out.println(myAttempt.threeSum_hash_partial_sum(nums));
        System.out.println(myAttempt.threeSum_sorted_array(nums));
    }


    public List<List<Integer>> threeSum_sorted_array(int[] nums) {
        // uses a set to remove dups
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length == 0) return new ArrayList<>(res);
        // will be a divide and conquer so O(n log n) speed.
        // TODO I saw the hints suggested doing this, but I didn't think it was ok to use a library function like this.
        // live and learn!!!
        Arrays.sort(nums);

        // Now the main loop, since its ordered you can get O(n2)
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            // inner "loop" closes in from both directions.
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == TARGET_SUM) res.add(List.of(nums[i], nums[j++], nums[k--]));
                else if (sum > TARGET_SUM) k--;
                else j++;
            }

        }
        return new ArrayList<>(res);

    }

    public List<List<Integer>> threeSum_hash_partial_sum(int[] nums) {

        if (nums.length < 3) {
            return List.of();
        }

        // create a map of sum to unique indices that made it up O(n2)
        Map<Integer, List<List<Integer>>> sumToOtherIndices = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                int sum = nums[j] + nums[k];
                if (!sumToOtherIndices.containsKey(sum)) {
                    sumToOtherIndices.put(sum, new ArrayList<>());
                }
                List<List<Integer>> solutions = sumToOtherIndices.get(sum);
                List<Integer> solution = List.of(j, k);
                if (!solutions.contains(solution)) {
                    solutions.add(solution);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            int partialSum = TARGET_SUM - nums[i];
            if (sumToOtherIndices.containsKey(partialSum)) {
                for (List<Integer> otherIndices : sumToOtherIndices.get(partialSum)) {

                    if (!otherIndices.contains(i)) {
                        List<Integer> solution = new ArrayList<>();
                        solution.add(nums[i]);
                        solution.add(nums[otherIndices.get(0)]);
                        solution.add(nums[otherIndices.get(1)]);
                        solution.sort(Comparator.naturalOrder());

                        if (!result.contains(solution)) {
                            result.add(solution);
                        }
                    }
                }
            }
        }

        return result;
    }


    public List<List<Integer>> threeSum_brute_force(int[] nums) {

        if (nums.length < 3) {
            return List.of();
        }
        List<List<Integer>> result = new ArrayList<>();

        // O(n3)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (TARGET_SUM == nums[i] + nums[j] + nums[k]) {

                        List<Integer> solution = new ArrayList<>();
                        solution.add(nums[i]);
                        solution.add(nums[j]);
                        solution.add(nums[k]);
                        solution.sort(Comparator.naturalOrder());

                        if (!result.contains(solution)) {
                            result.add(solution);
                        }
                    }
                }
            }
        }

        return result;
    }


}
