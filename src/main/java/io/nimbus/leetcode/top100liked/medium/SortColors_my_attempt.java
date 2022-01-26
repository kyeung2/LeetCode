package io.nimbus.leetcode.top100liked.medium;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors_my_attempt {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new SortColors_my_attempt().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    //TODO my solution worked using a merge sort, but their solution was also good. So it was good practice.
    public void sortColors(int[] nums) {

        divide(nums, 0, nums.length - 1);
    }

    private void divide(int[] nums, int l, int r) {

        if (l < r) {
            int m = l + (r - l) / 2;
            divide(nums, l, m);
            divide(nums, m + 1, r);//TODO good i remembered the +1
            conquer(nums, l, m, r);
        }
    }

    private void conquer(int[] nums, int l, int m, int r) {

        int[] L = new int[m - l + 1];//TODO I worked this out with a diagram
        int[] R = new int[r - m];

        for (int i = 0; i < L.length; i++) {
            L[i] = nums[l + i];
        }
        for (int i = 0; i < R.length; i++) {
            R[i] = nums[m + 1 + i];//TODO this also made sense.
        }

        int lIndex = 0, rIndex = 0, numsIndex = l;
        while (lIndex < L.length && rIndex < R.length) {
            if (L[lIndex] <= R[rIndex]) {
                nums[numsIndex++] = L[lIndex++];
            } else {
                nums[numsIndex++] = R[rIndex++];
            }
        }

        while (lIndex < L.length) {
            nums[numsIndex++] = L[lIndex++];
        }
        while (rIndex < R.length) {
            nums[numsIndex++] = R[rIndex++];
        }
    }
}
