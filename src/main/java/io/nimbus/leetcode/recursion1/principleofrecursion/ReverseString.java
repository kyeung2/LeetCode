package io.nimbus.leetcode.recursion1.principleofrecursion;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1440/
 */
public class ReverseString {

    // recursive implementation.
    public void reverseString(char[] s) {
        reverseString_recurse(s, 0, s.length - 1);
    }

    public void reverseString_recurse(char[] s, int frontPointer, int backPointer) {

        if (frontPointer >= backPointer) return;
        char temp = s[frontPointer];
        s[frontPointer] = s[backPointer];
        s[backPointer] = temp;
        reverseString_recurse(s, frontPointer + 1, backPointer - 1);
    }
}