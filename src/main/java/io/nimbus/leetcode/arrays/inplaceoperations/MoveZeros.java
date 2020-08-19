package io.nimbus.leetcode.arrays.inplaceoperations;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3157/
 */
public class MoveZeros {

    // this one felt good. After the explanation of the  two-pointer technique I feel more confidence to apply it.
    public void moveZeroes(int[] nums) {

        int writePointer = 0;
        for (int readPointer = 0; readPointer < nums.length; readPointer++) {

            if (nums[readPointer] != 0) {
                nums[writePointer] = nums[readPointer];
                writePointer++;
            }
        }

        for (int zeroPointer = writePointer; zeroPointer < nums.length; zeroPointer++) {
            nums[zeroPointer] = 0;
        }
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new MoveZeros().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
