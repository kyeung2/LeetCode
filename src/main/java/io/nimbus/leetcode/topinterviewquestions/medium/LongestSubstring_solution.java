package io.nimbus.leetcode.topinterviewquestions.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstring_solution {


    public static void main(String[] args) {

        var s = "A12A345A67890Aabcde";

        System.out.println(new LongestSubstring_solution().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {

        int longest = 0;
        //TODO this solution uses the same sliding window technique I used but in a smarter ways.
        //TODO 1. It keeps the indices of everything it's seen before in a Hash, so not needed the "REPEATED" uniqueness check
        //TODO 2. It jumps to the first appearance of the new repeat. My solution moving the window by 1 was incorrect.
        Map<Character, Integer> characterIndices = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {

            char endChar = s.charAt(end);

            // so the end character is the important one, have we seen it before, if so...
            if (characterIndices.containsKey(endChar)) {

                int endIndex = characterIndices.get(endChar);
                // what is the index we saw this character before? if it was more to the right than the current start, jump the start to there + 1.
                if (endIndex >= start) {
                    start = endIndex + 1;
                }
            }
            longest = Math.max(longest, end - start + 1);
            characterIndices.put(endChar, end);
        }

        return longest;

    }


}
