package io.nimbus.leetcode.arrays101.insert;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
 */
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                shiftRightOne(arr, i);
            }
        }
    }

    private void shiftRightOne(int[] arr, int i) {
        for (int j = arr.length - 2; j >= i; j--) {
            arr[j + 1] = arr[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        new DuplicateZeros().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
