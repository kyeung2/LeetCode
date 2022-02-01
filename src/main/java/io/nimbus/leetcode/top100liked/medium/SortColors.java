package io.nimbus.leetcode.top100liked.medium;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new SortColors().sortColors_two_pass(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors_two_pass(int[] nums) {
        // 2-pass
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            }
            if (nums[i] == 1) {
                count1++;
            }
            if (nums[i] == 2) {
                count2++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < count0) {
                nums[i] = 0;
            }
            //TODO perhaps the most intuitive and I like the count0 + count1
            else if (i < count0 + count1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }


    public void sortColors_one_pass(int[] nums) {
        // 1-pass
        //TODO to be fair this is pretty intuitive once you see it, swap.
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }
}

