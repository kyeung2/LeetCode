package io.nimbus.leetcode.top100liked.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation_my_attempt {


    //TODO this wasn't complete. I could not get a grasp on the question nor the solution will come back to this.
    public static void main(String[] args) {

        int[] nums = {1, 3, 2};

        new NextPermutation_my_attempt().nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {

        for (int i = nums.length - 1; i > 0; i--) {
            int currentNum = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                int other = nums[j];
                if (other < currentNum) {
                    nums[j] = currentNum;
                    nums[i] = other;
                    return;
                }
            }
        }
        // no swap made
        Arrays.sort(nums);
    }




}
