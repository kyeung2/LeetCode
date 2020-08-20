package io.nimbus.leetcode.arrays101.inplaceoperations;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3260/
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {

        int eventPointer = 0;
        int oddPointer = A.length - 1;

        outer:
        for (; eventPointer < A.length; eventPointer++) {

            if (A[eventPointer] % 2 == 1) {

                for (; oddPointer >= 0; oddPointer--) {

                    if (eventPointer == oddPointer)
                        break outer;

                    if (A[oddPointer] % 2 == 0) {
                        int temp = A[eventPointer];
                        A[eventPointer] = A[oddPointer];
                        A[oddPointer] = temp;
                        break;
                    }
                }
            }
        }

        return A;
    }


    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        new SortArrayByParity().sortArrayByParity(nums);
        System.out.println(Arrays.toString(nums));
    }
}
