package io.nimbus.leetcode.top100interview.easy.strings;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int frontPointer = 0;
        int backPointer = s.length - 1;

        while (frontPointer < backPointer) {
            char temp = s[frontPointer];
            s[frontPointer] = s[backPointer];
            s[backPointer] = temp;
            frontPointer++;
            backPointer--;
        }
    }


    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        {
            char[] chars = "hello".toCharArray();
            rs.reverseString(chars);
            System.out.println(Arrays.toString(chars));
        }
        {
            char[] chars = "Hannah".toCharArray();
            rs.reverseString(chars);
            System.out.println(Arrays.toString(chars));
        }
    }

}
