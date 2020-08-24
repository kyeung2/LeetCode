package io.nimbus.leetcode.queueandstack.lifo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * hhttps://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1361/
 */
public class ValidParentheses {


    // finally did one completely on my own, no hints. good.
    public boolean isValid(String s) {

        if(s == null)
            return false;

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (isOpen(c))
                stack.push(c);
            else if (stack.isEmpty() || !matches(stack.pop(), c))
                return false;
        }

        return stack.isEmpty();
    }

    private boolean matches(char open, char close) {
        return open == '{' && close == '}'// curly braces
                || open == '(' && close == ')' //parentheses
                || open == '[' && close == ']'; //square brackets

    }

    private boolean isOpen(char c) {
        return c == '{' || c == '(' || c == '[';
    }
}
