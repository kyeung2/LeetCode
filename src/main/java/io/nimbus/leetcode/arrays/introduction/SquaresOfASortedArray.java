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

    // I get the impression the website doesn't want me to implement it this way...
    public int[] sortedSquares_stream(int[] A) {
        return Arrays.stream(A).map(i -> i * i).sorted().toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SquaresOfASortedArray().sortedSquares(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(new SquaresOfASortedArray().sortedSquares_stream(new int[]{-7, -3, 2, 3, 11})));
    }
}
