package io.nimbus.leetcode.top100liked.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParenthesis_my_attempt {

    public static void main(String[] args) {


        // 2
        // ["(())", "(())()()"]
        // ["(())", "()()"]

        // 3
        // ["((()))", "((()))   (())()", "((()))(()) ()(())", "((()))(())()(())()()"]
        // ["((()))","(()())","(())()","()(())","()()()"]
        System.out.println(new GenerateParenthesis_my_attempt().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateParenthesis_recursive(combinations,  n);
        return combinations;

    }

    private void generateParenthesis_recursive(List<String> combinations, int n) {

        if(n == 0)
            return;


        // in the second iteration where n is now n-1, we need to add the split
        var combination = "(".repeat(n ) + ")".repeat(n);
        combinations.add(combination);
        generateParenthesis_recursive(combinations, n - 1);

    }





}
