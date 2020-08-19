package io.nimbus.leetcode.arrays.inplaceoperations;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3259/
 */
public class ReplaceElementsWithGreatestElementOnRightSide {

    // this was so difficult to implement. Got very confused over the indices annoyingly.
    public int[] replaceElements(int[] arr) {
        int rightMax = arr[arr.length - 1];

        // so we loop backwards from the second to last element, since that's going to be taken cared of by the -1 value
        // hence int i = arr.length - 2
        for (int i = arr.length - 2; i >= 0; i--) {

            // first remember the current value.
            // I stumbled here. I replaced the value before giving it a chance to contribute to the maximum.
            // 1. assign 2. use previous value to determine the max for the next iteration.
            int current = arr[i];
            // replace the current with the maximum right value
            arr[i] = rightMax;
            // work out the new maximum value
            rightMax = Math.max(current, rightMax);
        }

        // it doesn't if this line is executed before or after the loop. Just doing it afterwards to make clear it isn't
        // necessary for the loop's logic.
        arr[arr.length - 1] = -1;

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ReplaceElementsWithGreatestElementOnRightSide().replaceElements(new int[]{17, 18, 5, 4, 6, 1})));
    }
}
