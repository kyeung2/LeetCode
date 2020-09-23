package io.nimbus.leetcode.recursion2.backtracking;


/**
 * https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2796/
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        new MyAttempt().solveSudoku(board);
    }


    /**
     * A solution found at https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2796/discuss/15752/Straight-Forward-Java-Solution-Using-Backtracking
     * my attempt was surprisingly close. What I missed was the is_valid() functionality. Pretty smart. This person also
     * has a more compact isValid, which I haven't looked at carefully.
     */
    public static class MyAttemptModifiedWithSolution {


        public void solveSudoku(char[][] board) {
            if (board == null || board.length == 0)
                return;
            backtrack(board);
        }

        private boolean backtrack(char[][] board) {

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == '.') {

                        for (char k = '1'; k <= '9'; k++) {

                            if (is_valid(k, board, i, j)) {
                                //try this partial candidate solution
                                place(k, board, i, j);
                                // given the candidate, explore further.
                                if (backtrack(board))
                                    return true;
                                    // backtrack
                                else
                                    remove(board, i, j);
                            }
                        }
                        // entire recursive journey didn't yield a true, so need to return false and a previous
                        // iteration will backtrack.
                        return false;
                    }
                }
            }

            // you have solved completely if you make it out of the parsing without returning false.
            return true;
        }

        private void place(char candidate, char[][] board, int i, int j) {
            board[i][j] = candidate;
        }

        private void remove(char[][] board, int i, int j) {
            board[i][j] = '.';
        }

        private boolean is_valid(int candidate, char[][] board, int row, int column) {
            char[] rowChars = board[row];
            // if row contains
            if (rowContains(candidate, rowChars))
                return false;
                // if column contains
            else if (columnContains(candidate, board, column))
                return false;
                // if sub-grid contains
            else return !subGridContains(candidate, board, row, column);
        }

        private boolean subGridContains(int candidate, char[][] board, int row, int column) {
            int gridRow = (row / 3) * 3;
            int gridColumn = (column / 3) * 3;
            for (int i = gridRow; i < gridRow + 3; i++) {
                for (int j = gridColumn; j < gridColumn + 3; j++) {
                    if (board[i][j] == candidate)
                        return true;
                }
            }

            return false;
        }

        private boolean columnContains(int candidate, char[][] board, int column) {
            for (int rowNumber = 0; rowNumber < board.length; rowNumber++) {
                if (board[rowNumber][column] == candidate)
                    return true;
            }
            return false;
        }

        private boolean rowContains(int candidate, char[] chars) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == candidate)
                    return true;
            }
            return false;
        }

    }


    // doesn't end, doing something wrong. probably not remembering the candidates already tried?
    // it probably is
    public static class MyAttempt {

        public void solveSudoku(char[][] board) {
            if (board == null || board.length == 0)
                return;
            backtrack(board);
        }

        private void backtrack(char[][] board) {
            if (find_solution(board))
                return;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == '.') {
                        for (char k = 1; k <= 9; k++) {
                            char candidate = Character.forDigit(k, 10);
                            if (is_valid(candidate, board, i, j)) {
                                //try this partial candidate solution
                                place(candidate, board, i, j);
                                // given the candidate, explore further.
                                backtrack(board);
                                // backtrack
                                remove(board, i, j);
                            }
                        }

                    }
                }
            }
        }

        private void place(char candidate, char[][] board, int i, int j) {
            board[i][j] = candidate;
        }

        private void remove(char[][] board, int i, int j) {
            board[i][j] = '.';
        }

        private boolean is_valid(int candidate, char[][] board, int row, int column) {
            char[] rowChars = board[row];
            // if row contains
            if (rowContains(candidate, rowChars))
                return false;
                // if column contains
            else if (columnContains(candidate, board, column))
                return false;
                // if sub-grid contains
            else return !subGridContains(candidate, board, row, column);
        }

        private boolean subGridContains(int candidate, char[][] board, int row, int column) {
            int gridRow = (row / 3) * 3;
            int gridColumn = (column / 3) * 3;
            for (int i = gridRow; i < gridRow + 3; i++) {
                for (int j = gridColumn; j < gridColumn + 3; j++) {
                    if (board[i][j] == candidate)
                        return true;
                }
            }

            return false;
        }

        private boolean columnContains(int candidate, char[][] board, int column) {
            for (int rowNumber = 0; rowNumber < board.length; rowNumber++) {
                if (board[rowNumber][column] == candidate)
                    return true;
            }
            return false;
        }

        private boolean rowContains(int candidate, char[] chars) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == candidate)
                    return true;
            }
            return false;
        }

        private boolean find_solution(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                if (rowContains('.', board[i])) return false;
            }
            return true;
        }
    }


    public static void main(String[] args) {

        SudokuSolver solver = new SudokuSolver();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        solver.solveSudoku(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }
    }
}


/**
 @formatter:off
 back tracking template

 def backtrack(candidate):
    if find_solution(candidate):
        output(candidate)
        return

     # iterate all possible candidates.
     for next_candidate in list_of_candidates:
        if is_valid(next_candidate):
             # try this partial candidate solution
             place(next_candidate)
             # given the candidate, explore further.
             backtrack(next_candidate)
             # backtrack
             remove(next_candidate)
 @formatter:on
 */