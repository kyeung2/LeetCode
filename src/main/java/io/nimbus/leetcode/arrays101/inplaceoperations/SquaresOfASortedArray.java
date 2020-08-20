package io.nimbus.leetcode.arrays101.inplaceoperations;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3261/
 */
public class SquaresOfASortedArray {

    // this is obviously not what they are looking for.
    public int[] sortedSquares(int[] A) {

        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }


    // but their solutions all use another array. Though the point of this section was to practice in-place algorithms?
    // though this similar to my solution from

    // I believe this algo can be reworked to be in-place as well but not worth it at this point.
    // the fact they are working from both ends accounts for the big negative numbers at the start
    // and the big positive numbers at the end. And they compete after they are squared.

    public int[] sortedSquares_better_solution_found_in_comments(int[] A) {
        if (A == null) return null;

        int [] ans = new int[A.length];

        int start = 0, end = A.length - 1;

        int writePointer = end; // insert position.
        while (start <= end) { // <  or <=  ?   be careful about ==
            int pow1 = A[start] * A[start];
            int pow2 = A[end] * A[end];
            if (pow1 > pow2) {
                ans[writePointer--] = pow1;
                start++;
            } else {
                ans[writePointer--] = pow2;
                end--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        new SquaresOfASortedArray().sortedSquares(nums);
        System.out.println(Arrays.toString(nums));
    }
}
