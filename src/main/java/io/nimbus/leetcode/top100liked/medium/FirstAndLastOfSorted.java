package io.nimbus.leetcode.top100liked.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FirstAndLastOfSorted {


    public static void main(String[] args) {

//        {
//            int[] nums = {5, 7, 7, 8, 8, 10};
//            int target = 8;
//            int[] ret = new FirstAndLastOfSorted().searchRange(nums, target);
//            System.out.println(Arrays.toString(ret));
//        }

        {
            int[] nums = {1,2,2,2,2,2,2,2,2,6};
            int target = 2;
            System.out.println(Arrays.toString(new Their().searchRange(nums, target)));
        }
    }

    public int[] searchRange(int[] nums, int target) {

        int index = binarySearch_first(nums, target, 0, nums.length - 1);




        if (index == -1) {
            return new int[]{-1, -1};
        }

        int[] ret = new int[2];
        int startIndex = index;
        int endIndex = index;

        while (startIndex != 0 && nums[startIndex - 1] == target) {
            startIndex--;
        }

        while ((endIndex != nums.length - 1) && nums[endIndex + 1] == target) {
            endIndex++;
        }

        ret[0] = startIndex;
        ret[1] = endIndex;

        return ret;
    }

    private int binarySearch_first(int[] nums, int target, int l, int r) {

        if (l <= r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] >= target)
                return binarySearch_first(nums, target, l, mid - 1);

            return binarySearch_first(nums, target, mid + 1, r);
        }
        return -1;
    }





    public static class Their{
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[2];
            result[0] = findFirst(nums, target);
            result[1] = findLast(nums, target);
            return result;
        }

        //TODO interesting approach, the exit condition does not return the index immediately it continues to update it
        // until its "gone all the way".
        private int findFirst(int[] nums, int target){
            int idx = -1;
            int start = 0;
            int end = nums.length - 1;
            while(start <= end){
                int mid = (start + end) / 2;
                if(nums[mid] >= target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
                if(nums[mid] == target) {
                    idx = mid;
                }
            }
            return idx;
        }

        //TODO similarly this one continues to push to the right with mid+1 as <= so even if you are equal push further.
        private int findLast(int[] nums, int target){
            int idx = -1;
            int start = 0;
            int end = nums.length - 1;
            while(start <= end){
                int mid = (start + end) / 2;
                if(nums[mid] <= target){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
                if(nums[mid] == target) idx = mid;
            }
            return idx;
        }
    }
}
