package io.nimbus.leetcode.arrays101.conclusion;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3270/
 */
public class FinalAllNumbersDisappearedInAnArray {


    public List<Integer> findDisappearedNumbers(int[] nums) {

        // this outer for loop will ensure all values that can be placed are placed.
        for (int i = 0; i < nums.length; i++) {

            int value = nums[i];
            // is there a value in the correct location? if no, keep on jumping, replacing them to the correct location
            while (value != nums[value - 1]) {
                int temp = nums[value - 1];
                nums[value - 1] = value; // add tp the correct location
                value = temp;// and the previous value, repeat.
            }
        }

        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                missing.add(i + 1);
            }
        }

        return missing;
    }

    public List<Integer> findDisappearedNumbers_streams(int[] nums) {

        // this is obviously not what they want
        Set<Integer> unique = IntStream.of(nums).boxed().collect(toSet());
        return IntStream.rangeClosed(1, nums.length).filter(i -> !unique.contains(i)).boxed().collect(toList());
    }


    public static void main(String[] args) {

        System.out.println(new FinalAllNumbersDisappearedInAnArray().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
