package io.nimbus.leetcode.top100interview.medium;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray_my_attempt {

    public static void main(String[] args) {


//        //not rotated
//        {
//            int[] nums = {0, 1, 2, 4, 5, 6, 7};
//            int target = 0;
//            System.out.println(new SearchInRotatedSortedArray_my_attempt().search(nums, target));
//        }
//        //rotated
//        {
//            int[] nums = {4, 5, 6, 7, 0, 1, 2};
//            int target = 0;
//            System.out.println(new SearchInRotatedSortedArray_my_attempt().search(nums, target));
//        }
        //rotated
        {
            int[] nums = {4, 5, 6, 7, 8, 1, 2, 3};
            int target = 8;
            System.out.println(new SearchInRotatedSortedArray_my_attempt().search(nums, target));
        }
    }

    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {


            //TODO the problem states that its always rotated so the initial if statement doesn't do anything.
            //TODO as the solution I found, there are only 2 states the right or left side can be. so if you are right centric with a good example array it would have been kind of possible.
            //TOOO bur a bit of a failure, learning experience but need to get better :)
            boolean rotated = nums[start] > nums[end];
            int mid = start + (end - start) / 2;


            if (target == nums[mid]) {
                return mid;
            }

            if (!rotated) {

                if (target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {

                //TODO if rotated &&.... got a little stuck here
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }


}
