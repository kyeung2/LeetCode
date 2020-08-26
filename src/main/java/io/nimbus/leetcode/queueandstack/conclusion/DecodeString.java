package io.nimbus.leetcode.queueandstack.conclusion;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1379/
 */
public class DecodeString {


    // got this on my own good. Was a tossup between .split() and .toCharArray().
    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        for (String s1 : s.split("")) {

            if (s1.equals("]")) {
                String repeatingPhase = getRepeatingPhrase(stack);
                int repeats = getRepeats(stack);
                stack.push(repeatingPhase.repeat(repeats));

            } else
                stack.push(s1);
        }

        StringBuilder b = new StringBuilder();
        while (!stack.isEmpty())
            b.insert(0, stack.pop());

        return b.toString();
    }

    private int getRepeats(Deque<String> stack) {

        StringBuilder digits = new StringBuilder();

        while (!stack.isEmpty()) {
            String digit = stack.peek();
            if (!Character.isDigit(digit.toCharArray()[0])) {
                break;
            }
            digits.insert(0, stack.pop());
        }

        return Integer.parseInt(digits.toString());
    }

    private String getRepeatingPhrase(Deque<String> stack) {
        StringBuilder repeatingPhase = new StringBuilder();

        while (!stack.isEmpty()) {
            String letter = stack.pop();
            // break statements bad style.
            if (letter.equals("["))
                break;

            repeatingPhase.insert(0, letter);
        }
        return repeatingPhase.toString();
    }


    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("3[a]2[bc]"));
        System.out.println(decodeString.decodeString("3[a2[c]]"));
        System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
    }
}
