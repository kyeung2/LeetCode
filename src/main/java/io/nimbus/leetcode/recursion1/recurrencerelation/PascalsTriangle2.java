package io.nimbus.leetcode.recursion1.recurrencerelation;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3234/
 */
public class PascalsTriangle2 {

    private static class Pair {
        public int rowIndex, columnIndex;

        public Pair(int rowIndex, int columnIndex) {
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return rowIndex == pair.rowIndex &&
                    columnIndex == pair.columnIndex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rowIndex, columnIndex);
        }
    }


    // got on my own, but could use dp, but 2 ints as a key? the new record language feature one be nice.
    public List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<>();
        Map<Pair, Integer> dp = new HashMap<>();
        for (int columnIndex = 0; columnIndex < rowIndex + 1; columnIndex++) {
            row.add(getValue(new Pair(rowIndex, columnIndex), dp));
        }

        return row;
    }

    private int getValue(Pair p, Map<Pair, Integer> dp) {

        if (p.rowIndex == 0 || p.columnIndex == 0 || p.rowIndex == p.columnIndex) return 1;
        if (dp.containsKey(p)) return dp.get(p);

        Pair aboveLeft = new Pair(p.rowIndex - 1, p.columnIndex - 1);
        Pair aboveRight = new Pair(p.rowIndex - 1, p.columnIndex);
        int aboveLeftValue = getValue(aboveLeft, dp);
        int aboveRightValue = getValue(aboveRight, dp);
        dp.put(aboveLeft, aboveLeftValue);
        dp.put(aboveRight, aboveRightValue);

        return aboveLeftValue + aboveRightValue;
    }

    public static void main(String[] args) {

        PascalsTriangle2 pascalsTriangle2 = new PascalsTriangle2();

        System.out.println(pascalsTriangle2.getRow(0));
        System.out.println(pascalsTriangle2.getRow(1));
        System.out.println(pascalsTriangle2.getRow(2));
        System.out.println(pascalsTriangle2.getRow(3));

        System.out.println(pascalsTriangle2.getRow(40));
    }

}
