package io.nimbus.leetcode.queueandstack.lifo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Set;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1394/
 */
public class EvaluateReversePolishNotation {

    private static final Set<String> OPERATORS = Set.of("+", "-", "*", "/");

    // found this really easy, the problem statement was very clear and the algorithm just jumped off the page.
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {

            if (OPERATORS.contains(token)) {
                int rightOperand = stack.pop();
                int leftOperand = stack.pop();
                stack.push(calculate(token, leftOperand, rightOperand));
            } else
                stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }

    private int calculate(String operator, int leftOperand, int rightOperand) {
        switch (operator) {
            case "+":
                return leftOperand + rightOperand;
            case "-":
                return leftOperand - rightOperand;
            case "*":
                return leftOperand * rightOperand;
            case "/":
                return leftOperand / rightOperand;
            default:
                throw new IllegalArgumentException("unknown operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String[] T = {"2", "1", "+", "3", "*"};
        System.out.println(Arrays.toString(T));
        System.out.println(new EvaluateReversePolishNotation().evalRPN(T));
    }
}
