package io.nimbus.leetcode.arrays.introduction;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3240/
 */
public class SquaresOfASortedArray {


    public int[] sortedSquares(int[] A) {

        int[] res = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            res[i] = A[i] * A[i];
        }

        Arrays.sort(res);
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SquaresOfASortedArray().sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }
}
