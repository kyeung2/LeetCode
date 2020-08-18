package io.nimbus.leetcode.arrays.introduction;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3237/
 */
public class FindNumbersWithEven {

    public int findNumbers(int[] nums) {
        return (int) Arrays.stream(nums).filter(this::hasEvenDigits).count();
    }

    private boolean hasEvenDigits(int i) {
        return countDigits(i) % 2 == 0;
    }

    private int countDigits(int i) {
        int count = 0;
        int x = i;
        while (x != 0) {
            count++;
            x /= 10;
        }
        return count;
    }

    public int findNumbers_strings(int[] nums) {
        return (int) Arrays.stream(nums)
                .map(i -> Integer.toString(i).length())
                .filter(length -> length % 2 == 0)
                .count();
    }

    public static void main(String[] args) {
        System.out.println(new FindNumbersWithEven().findNumbers(new int[]{555, 901, 482, 1771}));
        System.out.println(new FindNumbersWithEven().findNumbers_strings(new int[]{555, 901, 482, 1771}));
    }
}
