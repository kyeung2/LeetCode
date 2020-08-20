package io.nimbus.leetcode.arrays101.introduction;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3238/
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int max = 0;

        for (int i : nums) {
            if (i == 1)
                count++;
            else {
                if (count > max)
                    max = count;
                count = 0;
            }
        }

        if (count > max)
            max = count;

        return max;
    }


    public static void main(String[] args) {
        System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{1, 0, 1, 1}));
    }
}
