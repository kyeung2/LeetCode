package io.nimbus.leetcode.recursion2.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2804/
 */
public class NQueens2 {


    // intuition: constraints are 1. not same row, 2. not same column, 2 not same diagonal
    // so far seems like a good explanation https://www.youtube.com/watch?v=wGbuCyNpxIg
    // I understand the algorithm but the isValid I don't understand fully. Need more time going over this one.
    // very beyond me this one. Nice technique but no where close to getting this on my own.

    public int totalNQueens(int n) {
        return nQueens(n).size();
    }

    public static List<List<Integer>> nQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        solveNQueens(n, 0, new ArrayList<>(), result);
        result.forEach(System.out::println);
        return result;
    }

    private static void solveNQueens(int n, int row, List<Integer> columnPlacements, List<List<Integer>> result) {
        // our goal
        if (row == n)
            result.add(new ArrayList<>(columnPlacements));
        else {
            for (int col = 0; col < n; col++) {
                // our choice
                columnPlacements.add(col);
                // our constraints
                if (isValid(columnPlacements))
                    // explore in the next row
                    solveNQueens(n, row + 1, columnPlacements, result);
                // undo our choice
                columnPlacements.remove(columnPlacements.size() - 1);
            }
        }
    }

    // check the constraints
    private static boolean isValid(List<Integer> columnPlacements) {
        int rowId = columnPlacements.size() - 1;
        Integer currentRow = columnPlacements.get(rowId);

        /*
        for valid case the follow will be recursively called for a n=4 input.
        [1]
        [1,3]
        [1,3,0]
        [1,3,0,2]
         */
        //
        for (int i = 0; i < rowId; i++) {
            Integer aRow = columnPlacements.get(i);
            int diff = Math.abs(aRow - currentRow);
            if (

                    // same row is invalid
                    diff == 0 ||
                            // OR.. this checks if 2 columns are in a diagonal,but I can't see why?
                            diff == rowId - i)
                return false;
        }

        return true;
    }


    // attempted to follow the pseudo code provided in the explanation of backtracking but made errors and gave up
    static class MyAttempt {

        // so dumb that I have to create all this boilerplate
        public static class Cell {
            public int row;
            public int col;

            public Cell(int row, int col) {
                this.row = row;
                this.col = col;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Cell cell = (Cell) o;
                return row == cell.row &&
                        col == cell.col;
            }

            @Override
            public int hashCode() {
                return Objects.hash(row, col);
            }
        }


        public int totalNQueens(int n) {

            int count = 0;
            for (int row = 0; row < n; row++) {
                // iterate through columns at the current row.
                for (int col = 0; col < n; col++) {
                    // explore this partial candidate solution, and mark the attacking zone

                    Cell c = new Cell(row, col);
                    if (is_not_under_attack(c)) {
                        place_queen(c);
                        if (row + 1 == n)
                            count += 1;


                    }
                }
            }
            return count;
        }

        private boolean is_not_under_attack(Cell c) {
            return true;
        }

        private void place_queen(Cell c) {

            // this will mark the queen & all the attacking zones
        }

        private void remove_queen(Cell c) {

            // remove queen at cell(row, col), & remove its attacking zone.
        }

    }

    public static void main(String[] args) {
        NQueens2 n = new NQueens2();
        System.out.println(n.totalNQueens(4));// = 2
    }
}
