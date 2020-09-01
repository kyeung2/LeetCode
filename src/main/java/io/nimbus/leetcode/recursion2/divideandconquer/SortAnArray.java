package io.nimbus.leetcode.recursion2.divideandconquer;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2944/
 */
public class SortAnArray {

    public int[] sortArray(int[] nums) {
        return mergeSort_topdown(nums);
    }

    public int[] mergeSort_topdown(int[] input) {

        if (input.length <= 1)
            return input;

        int mid = input.length / 2;
        int[] left = mergeSort_topdown(Arrays.copyOfRange(input, 0, mid));
        int[] right = mergeSort_topdown(Arrays.copyOfRange(input, mid, input.length));
        return merge_topdown(left, right);
    }

    private int[] merge_topdown(int[] left, int[] right) {
        int[] ret = new int[left.length + right.length];
        int retIndex = 0, leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex])
                ret[retIndex++] = left[leftIndex++];
            else
                ret[retIndex++] = right[rightIndex++];
        }
        // copy over the remaining
        while (leftIndex < left.length) {
            ret[retIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            ret[retIndex++] = right[rightIndex++];
        }
        return ret;
    }


    public static void main(String[] args) {
        SortAnArray s = new SortAnArray();
        System.out.println(Arrays.toString(s.sortArray(new int[]{5, 2, 3, 1})));
    }
}
