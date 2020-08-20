package io.nimbus.leetcode.topinterviewquestionseasy.strings;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
 */
public class ReverseInteger {

    public int reverse(int x) {

        try {
            int current = x;
            int res = 0;
            while (current != 0) {
                int digit = current % 10;
                // move previous digits up 1 *10, and add digit
                // also didn't know about the xxxExact() methods, cool
                res = Math.multiplyExact(res, 10) + digit;
                current /= 10;
            }

            return res;
        } catch (ArithmeticException e) {
            return 0;
        }
    }


    public static void main(String[] args) {
        ReverseInteger rs = new ReverseInteger();

        System.out.println(rs.reverse(123));
        System.out.println(rs.reverse(-123));
        System.out.println(rs.reverse(120));
        System.out.println(rs.reverse(1534236469));


    }

}
