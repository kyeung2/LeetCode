package io.nimbus.leetcode.top100liked.medium;

public class NQueenProblem {

    private final int n;

    public NQueenProblem(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        var problem = new NQueenProblem(5);
        problem.solve();
    }

    private void solve() {

        var board = buildBoard();

        if (backtrackSolve(board, 0)) {
            printBoard(board);

        } else {
            System.out.println("no solution found");
        }

    }

    private boolean backtrackSolve(int[][] board, int col) {

        // reached the end of the cols, therefore have a full solution, return true.
        if (col >= n) {
            return true;
        }

        for (int row = 0; row < n; row++) {

            if (isSafeToAdd(board, row, col)) {
                board[row][col] = 1;

                if (backtrackSolve(board, col + 1)) {
                    return true;
                }
                // the above if statement failed, so this current entry has no "fuller" solutions, backtrack it.
                board[row][col] = 0;
            }
        }

        // if not shortcut and reached this point, all possibilities were attempted. No solution found.
        return false;
    }

    private boolean isSafeToAdd(int[][] board, int row, int col) {

        // check this row does not have anything to the left of the col we want to add in

        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // check the up/left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }


        // check the bottom/left diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private void printBoard(int[][] board) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                System.out.print(" " + board[row][col] + " ");
            }
            System.out.println();
        }
    }

    /**
     * The board is represented by an int[row][col]
     */
    private int[][] buildBoard() {
        return new int[n][n];
    }

}
