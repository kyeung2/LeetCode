package io.nimbus.leetcode.arrays.search;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3251/
 */
public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {

        if (A == null || A.length < 3)
            return false;

        int phase = -1;
        for (int i = 0; i < A.length - 1; i++) {

            int current = A[i];
            int next = A[i + 1];
            if (current == next) {
                return false;
            } else if (current < next) {
                // strict increase;
                if (phase == -1)
                    phase = 1;
                else if (phase != 1)
                    return false;
            } else {
                // strict decrease;
                if (phase == 1)
                    phase = 2;
                else if (phase != 2) {
                    return false;
                }
            }
        }

        return phase == 2;
    }

    public static void main(String[] args) {
        System.out.println(new ValidMountainArray().validMountainArray(new int[]{2, 1}));
        System.out.println(new ValidMountainArray().validMountainArray(new int[]{3, 5, 5}));
        System.out.println(new ValidMountainArray().validMountainArray(new int[]{0, 3, 2, 1}));
    }
}
