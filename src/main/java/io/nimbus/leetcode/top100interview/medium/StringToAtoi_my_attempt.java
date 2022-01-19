package io.nimbus.leetcode.top100interview.medium;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToAtoi_my_attempt {


    public static void main(String[] args) {
        System.out.println(new StringToAtoi_my_attempt().myAtoi("  -413"));
    }

    //TODO my attempt, feels like its all over the place.
    // TODO the suggested solution uses index i * 10 for each iteration to build the integer digit by digit.
    public int myAtoi(String s) {

        Character sign = null;
        int start = -1;
        int end = -1;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // skip if leading spaces
            if (c == ' ' && start == -1 && sign == null) {
                continue;
            }
            // assign sign character if first time seeing it and not started digits
            else if ((c == '-' || c == '+') && start == -1 && sign == null) {
                sign = c;
            } else if (Character.isDigit(c)) {
                if (start == -1) {
                    start = i;
                }
                end = i + 1;
            }
            // break once digit chain is broken
            else {
                break;
            }
        }

        if (start != -1) {
            String allDigits = s.substring(start, end);
            var bigInt = new BigInteger(allDigits);

            if (sign != null && sign == '-') {
                bigInt = bigInt.negate();
                // take max of negative number, pulling closer towards 0, i.e. away from the overflow.
                return bigInt.max(BigInteger.valueOf(Integer.MIN_VALUE)).intValue();
            } else {
                // take min of positive number, pulling closer towards 0, i.e. away from the overflow.
                return bigInt.min(BigInteger.valueOf(Integer.MAX_VALUE)).intValue();
            }
        }

        return 0;
    }
}
