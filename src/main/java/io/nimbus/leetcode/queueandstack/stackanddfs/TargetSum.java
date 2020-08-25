package io.nimbus.leetcode.queueandstack.stackanddfs;


/**
 * https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1389/
 */
public class TargetSum {

    // this problem was beyond me. Even looking at the solutions I'm not too confident in
    // their approaches. The brute force solution makes sense. The others not so much.

    public int findTargetSumWays(int[] nums, int S) {
        return new BruteForce().findTargetSumWays(nums, S);
    }

    //https://leetcode.com/problems/target-sum/solution/
    static class BruteForce {
        int count = 0;

        public int findTargetSumWays(int[] nums, int S) {
            calculate(nums, 0, 0, S);
            return count;
        }

        public void calculate(int[] nums, int i, int sum, int S) {
            if (i == nums.length) {
                if (sum == S)
                    count++;
            } else {
                calculate(nums, i + 1, sum + nums[i], S);
                calculate(nums, i + 1, sum - nums[i], S);
            }
        }
    }


    //https://thecodingsimplified.com/target-sum/
    // a brilliant if not obscure solution.
    static class CodingSimplified {

        public static int ifTargetSumExists(int[] arr, int sum) {
            if(arr.length == 0) {
                return 0;
            }

            int sumOfArrayElement = 0;

            for(int i = 0; i < arr.length; i++) {
                sumOfArrayElement = sumOfArrayElement + arr[i];
            }

            if(sumOfArrayElement < sum || (sumOfArrayElement + sum) % 2 != 0) {
                return 0;
            }

            int sumToCheck = (sumOfArrayElement + sum) / 2;

            return countSubsetsWithSumEqualToGivenSum(arr, sumToCheck);
        }

        private static int countSubsetsWithSumEqualToGivenSum(int[] arr, int sum) {
            if(arr.length == 0 || sum <= 0) {
                return 0;
            }

            int n = arr.length;

            int[][] count = new int[n][sum + 1];

            for(int i = 0; i < n; i++) {
                count[i][0] = 1;
            }

            for(int j = 0; j <= sum; j++) {
                if(arr[0] == j) {
                    count[0][j] = 1;
                }
            }

            for(int i = 1; i < n; i++) {
                for(int j = 1; j <= sum; j++) {

                    int includingCurrentValue = 0;
                    int excludingCurrentValue = 0;

                    if(arr[i] <= j) {
                        includingCurrentValue = count[i - 1][j - arr[i]];
                    }

                    excludingCurrentValue = count[i - 1][j];

                    count[i][j] = includingCurrentValue + excludingCurrentValue;
                }
            }

            return count[n - 1][sum];
        }

    }
}