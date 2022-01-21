package io.nimbus.leetcode.top100liked.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum_my_attempt {

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        System.out.println(new CombinationSum_my_attempt().combinationSum(candidates, target));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        //TODO ok try to do this with a bit of confidence!
        //TODO feels like a backtracking task, I thought about modulo as well but that doesn't work once P(>1)
        //TODO need to shortcut paths that already has been tried so the lists needs to be unique
        //TODO I did it! a variation on backtracking that does not shortcut and finds all possible solutions. https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)


        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] candidates, int target, int sum, List<List<Integer>> results, List<Integer> current) {

        if (target == sum) {
            var result = new ArrayList<>(current);
            result.sort(Comparator.naturalOrder());
            if (!results.contains(result))
                results.add(result);
            return;
        }

        for (int candidate : candidates) {
            if (sum + candidate <= target) {
                current.add(candidate);
                backtrack(candidates, target, sum + candidate, results, current);
                int index = current.size() - 1;
                current.remove(index);
            }
        }
    }
}

