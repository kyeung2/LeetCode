package io.nimbus.leetcode.top100likedquestions_medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations_my_attempt {


    //TODO solutions show you can use a simple array since the keys are index positions! simply add 0 1 placeholders for the first 2 positions.
    private static final Map<Character, List<Character>> MAPPINGS = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
    );

    //TODO i.e. this is much more compact.
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static void main(String[] args) {

        String digits = "234";
        System.out.println(new LetterCombinations_my_attempt().letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {

        List<String> combinations = new ArrayList<>();
        letterCombinations_recurse(digits, 0, "", combinations);

        return combinations;
    }

    private void letterCombinations_recurse(String digits, int index, String combination, List<String> combinations) {

        if (index < digits.length()) {

            //TODO if the Map or array of mappings, could have used Character.getNumericValue();
            for (char c : MAPPINGS.get(digits.charAt(index))) {
                letterCombinations_recurse(digits, index + 1, combination + c, combinations);
            }
        } else if (!combination.isEmpty()) {
            combinations.add(combination);
        }
    }

}
