package io.nimbus.leetcode.arrays.insert;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/
 */
public class MergeSortedArray {


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int total = n + m;
        int nums1Pointer = 0;
        int nums2Pointer = 0;
        int[] temp = new int[total];
        for (int i = 0; i < total; i++) {

            int value;
            // works but subtle. != as the last valid use of the pointer is the index. and then +1 will be == to m or n.
            if (nums1Pointer != m && nums2Pointer != n) {
                int nums1Value = nums1[nums1Pointer];
                int nums2Value = nums2[nums2Pointer];
                if (nums1Value < nums2Value) {
                    value = nums1Value;
                    nums1Pointer++;
                } else {
                    value = nums2Value;
                    nums2Pointer++;
                }
            } else if (nums1Pointer < m) {
                value = nums1[nums1Pointer];
                nums1Pointer++;

            } else {
                value = nums2[nums2Pointer];
                nums2Pointer++;
            }

            temp[i] = value;
        }

        if (temp.length >= 0) System.arraycopy(temp, 0, nums1, 0, temp.length);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        new MergeSortedArray().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
