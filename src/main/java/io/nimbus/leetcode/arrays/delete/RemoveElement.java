package io.nimbus.leetcode.arrays.delete;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3247/
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int elementsDeleted = 0;
        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] == val) {
                elementsDeleted++;
                //nums[i] = 0; this is not required in the exercise as it states, the remaining can be anything.
                shiftLeft(nums, i);
            }
        }

        return nums.length - elementsDeleted;
    }

    private void shiftLeft(int[] nums, int i) {
        for (int i1 = i + 1; i1 < nums.length; i1++) {
            nums[i1 - 1] = nums[i1];
        }
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int removedElements = new RemoveElement().removeElement(nums, 2);
        System.out.println(removedElements);
        System.out.println(Arrays.toString(nums));
    }
}
