package io.nimbus.leetcode.topinterviewquestions.medium;

/**
 * https://leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers_my_attempt {

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;

//        int dividend = 20;
//        int divisor = 5;

        System.out.println(new DivideTwoIntegers_my_attempt().divide(dividend, divisor));
    }
    // TODO had no idea about this one. And I feel pretty ok with that so the key insights is as follows.
    // 1. a division equation can be reorganised as a multiplication
    // 2. you can use left and right shift operators which gives you (num * 2) and  (num / 2) respectively
    // 3. so something like 10/3 === 10 = 3*2 + 3*1 === 3*(2^1) + 3*(2^0) === 3*((2^1)+(2^0))
    // 3. so first iteration 3  * 2^1 == 6, if we went further 3 * 2^2 = 12, which is too much, so you take the 10-6. And do again with the 4 remaining. Which is 3 * 2^0. Thus ((2^1)+(2^0)) = 3 is our answer

    public int divide(int dividend, int divisor) {
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true : false;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long result = 0;
        while(absDividend >= absDivisor){
            long tmp = absDivisor, count = 1;
            while(tmp <= absDividend){
                tmp <<= 1;
                count <<= 1;
            }
            result += count >> 1;
            absDividend -= tmp >> 1;
        }
        return  isNegative ? (int) ~result + 1 : result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }
}
