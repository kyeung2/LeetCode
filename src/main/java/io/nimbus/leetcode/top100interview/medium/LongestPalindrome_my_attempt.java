package io.nimbus.leetcode.top100interview.medium;


/**
 * https://leetcode.com/problems/longest-palindromic-substring
 */
public class LongestPalindrome_my_attempt {



    public String longestPalindrome(String s) {

        // TODO brute force the solution.
        // TODO I did think of a expand a root solution as well, with a O(n2) time complexity. I think my current is O(n3)
        // TODO and surprisingly the expand solution is discussed
        String longest = "";
        for (int i = 0; i < s.length(); i++) {

            for (int j = i + 1; j <= s.length(); j++) {

                var candidate = s.substring(i, j);
                if (candidate.length() > longest.length() && isPalindrome(candidate)) {
                    longest = candidate;
                }

            }
        }

        return longest;
    }

    private boolean isPalindrome(String candidate) {

        for (int i = 0, j = candidate.length() - 1; i < j; i++, j--) {
            if (candidate.charAt(i) != candidate.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
       var s =  "a";

        System.out.println(new LongestPalindrome_my_attempt().longestPalindrome(s));
    }


}
