package io.nimbus.leetcode.arrays.delete;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3248/
 */
public class RemoveDuplicates {

    //
    public int removeDuplicates(int[] nums) {

        int uniqueIndex = 0;
        int i = 0;
        while (i < nums.length) {
            int value = nums[i];
            int r = i;
            while (r < nums.length && value == nums[r])
                r++;

            i = r > i ? r : +1;

            nums[uniqueIndex] = value;
            uniqueIndex++;
        }

        return uniqueIndex;
    }


    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int removedElements = new RemoveDuplicates().removeDuplicates(nums);
        System.out.println(removedElements);
        System.out.println(Arrays.toString(nums));
    }
}
