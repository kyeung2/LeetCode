package io.nimbus.leetcode.arrays.conclusion;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3231/
 */
public class ThirdMaximumNumber {

    // one of the test cases uses Integer.MIN_VALUE, therefore using null as the default state to check
    public int thirdMax(int[] nums) {

        Integer max = null;
        Integer max2nd = null;
        Integer max3rd = null;
        for (int num : nums) {
            if (max == null || num > max) {
                max3rd = max2nd;
                max2nd = max;
                max = num;
            } else if (num != max && (max2nd == null || num > max2nd)) {
                max3rd = max2nd;
                max2nd = num;
            } else if (num != max && num != max2nd && (max3rd == null || num > max3rd)) {
                max3rd = num;
            }
        }

        return max3rd != null ? max3rd : max != null ? max : nums[0];
    }

    public static void main(String[] args) {
//        System.out.println(new ThirdMaximumNumber().thirdMax(new int[]{5, 2, 2}));
        //  System.out.println(new ThirdMaximumNumber().thirdMax(new int[]{2, 2, 3, 1}));

//        System.out.println(new ThirdMaximumNumber().thirdMax(new int[]{1, 2, -2147483648}));
        System.out.println(new ThirdMaximumNumber().thirdMax(new int[]{1,2,2,5,3,5}));
    }
}
