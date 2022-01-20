package io.nimbus.leetcode.top100interview.medium;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {

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
            System.out.println(new SearchInRotatedSortedArray().search(nums, target));
            System.out.println(new SearchInRotatedSortedArray().search_other_good_solution(nums, target));
        }
    }

    public int search(int[] nums, int target) {

        int n = nums.length;
        int lo = 0, hi = n - 1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot = lo;
        lo = 0;
        hi = n - 1;
        // The usual binary search and accounting for rotation.
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int realmid = (mid + rot) % n;
            if (nums[realmid] == target) return realmid;
            if (nums[realmid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }


    public int search_other_good_solution(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;


            //TODO I like the reasoning in this approach with a clear example of what the state can be

            if (nums[mid] > nums[end]) {  // eg. 3,4,5,6,1,2
                if (target > nums[mid] || target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {  // eg. 5,6,1,2,3,4
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        if ( target != nums[start]) return -1;
        return start;
    }

}
