package io.nimbus.leetcode.recursion2.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2798/
 */
public class Combinations {

    // took the solution from https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2798/discuss/27002/Backtracking-Solution-Java
    // immediately, didn't understand the problem statement at all.
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        // starts from 1 to n, hence the 1 being passed
        combine(combs, new ArrayList<>(), 1, n, k);
        return combs;
    }

    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {

        // once k is zero, the comb list has enough elements inside. So add to the list of results
        if (k == 0) {
            combs.add(List.copyOf(comb));
            // the return is important here so, we do not try to add a 3rd element, if k=2 for instance.
            return;
        }
        for (int i = start; i <= n; i++) {

            // I can sort of see the template here. Though not confident I would have got this solution on my own.
            // observation 1, all numbers are valid
            comb.add(i);

            // all numbers are valid because the back-tracking algorithm does a start+1, very smart
            // 1. for all the positions of k, you will not have a repeat e.g. no [1,1]
            // 2. as you go deeper into the recursion stack start reduces meaning given n=4, k=2
            //  - 3 iterations for start 1, [1,2],[1,3],[1,4]
            //  - 2 iterations for start 2, [2,4],[2,3]
            //  - 1 iteration for start 3, [3,4]

            combine(combs, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {

        Combinations c = new Combinations();
        {
            List<List<Integer>> combine = c.combine(4, 2);
            System.out.println(combine);
        }

        {
            List<List<Integer>> combine = c.combine(1, 1);
            System.out.println(combine);
        }

    }
}
