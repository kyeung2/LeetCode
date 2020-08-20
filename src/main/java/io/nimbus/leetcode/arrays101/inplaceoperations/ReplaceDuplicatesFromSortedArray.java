package io.nimbus.leetcode.arrays101.inplaceoperations;

import io.nimbus.leetcode.arrays101.delete.RemoveDuplicates;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3258/
 */
public class ReplaceDuplicatesFromSortedArray {


    public int removeDuplicates(int[] nums) {
        // my original algorithm was already in-place.
        return  new RemoveDuplicates().removeDuplicates(nums);
    }




    // similar algorithm to mine. I like the naming convention used. read/writePointer.
    // they additionally checked for an edge case that I didn't.
    // interesting they do a comparison with a readPointer-1 and initialise that pointer on index 1, much easier
    // to follow. Will use this technique going forward.
    // known as the "two-pointer technique."

    public int removeDuplicates_from_explanation(int[] nums) {

        // Check for edge cases.
        if (nums == null) {
            return 0;
        }

        // Use the two pointer technique to remove the duplicates in-place.
        // The first element shouldn't be touched; it's already in its correct place.
        int writePointer = 1;
        // Go through each element in the Array.
        for (int readPointer = 1; readPointer < nums.length; readPointer++) {
            // If the current element we're reading is *different* to the previous
            // element...
            if (nums[readPointer] != nums[readPointer - 1]) {
                // Copy it into the next position at the front, tracked by writePointer.
                nums[writePointer] = nums[readPointer];
                // And we need to now increment writePointer, because the next element
                // should be written one space over.
                writePointer++;
            }
        }

        // This turns out to be the correct length value.
        return writePointer;
    }
}
