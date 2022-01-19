package io.nimbus.leetcode.top100interview.medium;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstring_my_attempt {


    public static void main(String[] args) {

        var s = "pwwkew";

        System.out.println(new LongestSubstring_my_attempt().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {

        // covers empty string and string of length 1
        int stringLength = s.length();
        if (stringLength <= 1) {
            return stringLength;
        }
        int longest = 1;

        // start with the smallest substring candidate of length 2.
        for (int start = 0, end = 2; end <= stringLength; ) {
            if (isUnique(s, start, end)) {
                longest = end - start;
                end++;
            }
            // if there is a duplicate in the substring move the "largest window" by 1 to the right.
            else {
                end++;
                start++;
            }
        }

        return longest;

    }

    private boolean isUnique(String s, int start, int end) {

        var uniqueChars = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (!uniqueChars.add(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
