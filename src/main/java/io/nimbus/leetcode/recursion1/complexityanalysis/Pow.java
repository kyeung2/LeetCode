package io.nimbus.leetcode.recursion1.complexityanalysis;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2380/
 */
public class Pow {

    public double myPow_solution_from_discussion(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        // the exponent being a power of 2 you can do the following? didn't know.
        return (n % 2 == 0) ? myPow_solution_from_discussion(x * x, n / 2) : x * myPow_solution_from_discussion(x * x, n / 2);
    }

    // my solution didn't cover all the cases. I tried to use tail recursion as the trail indicated.
    public double myPow(double x, int n) {

        boolean negativeExponent = n < 0;
        double tail = tail(x, Math.abs(n), 1);
        return negativeExponent ? 1 / tail : tail;
    }

    public double tail(double x, int n, double accum) {
        if (n == 0) return 1;
        if (n == 1) return x * accum;
        return tail(x, n - 1, accum * x);
    }

    public static void main(String[] args) {
        Pow p = new Pow();
        System.out.println(p.myPow(2, 0));
        System.out.println(p.myPow(2, 1));
        System.out.println(p.myPow(2, 2));
        System.out.println(p.myPow(2, 3));
        System.out.println(p.myPow(5, -3));
    }
}
