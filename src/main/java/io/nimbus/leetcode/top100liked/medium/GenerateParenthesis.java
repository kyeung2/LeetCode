package io.nimbus.leetcode.top100liked.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {

    public static void main(String[] args) {

        System.out.println(new GenerateParenthesis().generateParenthesis(3));
//        System.out.println(new GenerateParenthesis().generateParenthesis_2(3));
    }


    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max) {

        System.out.println("open: "+ open + ", close: "+ close + ", s: "+ str);

        //TODO OK fine i couldn't get the solution so lets learn from this.
        // TODO key insight 1:the solution is complete WHEN the size of the partial answer is big enough.
        if (str.length() == max * 2) {
            System.out.println("adding!");
            list.add(str);
            return;
        }


        // it iteratively builds the solution adding to the string as I did. but with the concept of open and closed counters
        if (open < max)
            backtrack(list, str + "(", open + 1, close, max);


//        // TODO another key insight is that it bleeds the processing into another recursive loop only allowing the close to be called to match up to the open.
        if (close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }

    public List<String> generateParenthesis_2(int n) {
        List<String> res = new ArrayList<>();
        helper(res,n,0,"");
        return res;
    }

    private void helper(List<String> res, int left, int right, String s) {
        System.out.println("left: "+ left + ", right: "+ right + ", s: "+ s);
        if (left == 0 && right == 0) {
            System.out.println("adding!");
            res.add(s);
            return;
        }
        if (left > 0) helper(res,left - 1, right + 1, s + "(");
        if (right > 0) helper(res,left, right - 1, s + ")");
    }
}
