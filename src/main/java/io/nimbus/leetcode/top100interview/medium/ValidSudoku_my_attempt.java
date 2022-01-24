package io.nimbus.leetcode.top100interview.medium;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku_my_attempt {


    //TODO so I successfully implemented a back tracking solution for finding a valid solution but this was not the question...
    //TODO what I should have done is follow the question properly, thus even invalid boards are seen to be valid in the
    // context of the question asked...
    public static void main(String[] args) {

        // valid
//        {
//            char[][] board = {
//                    {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
//                    , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
//                    , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
//                    , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
//                    , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
//                    , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
//                    , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
//                    , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
//                    , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//            };
//
//            System.out.println(new ValidSudoku_my_attempt().isValidSudoku(board));
//        }
//        // invalid
//        {
//            char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
//                    , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
//                    , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
//                    , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
//                    , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
//                    , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
//                    , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
//                    , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
//                    , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//            System.out.println(new ValidSudoku_my_attempt().isValidSudoku(board));
//        }

        // should be valid
        {
            char[][] board = {
                    {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                    {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                    {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                    {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                    {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                    {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                    {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                    {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                    {'9', '.', '.', '.', '.', '.', '.', '.', '.'}};

            System.out.println(new ValidSudoku_my_attempt().isValidSudoku(board));
        }
    }




    public boolean isValidSudoku(char[][] board) {
        return isValidSudoku(board, 0);
    }


    public boolean isValidSudoku(char[][] board, int col) {
        // so did all the columns, we are done.
        if (col > 8) {
            return true;
        }

        for (int row = 0; row < 8; row++) {
            if (board[row][col] == '.') {
                for (int movePrim = 1; movePrim <= 9; movePrim++) {
                    char move = Character.forDigit(movePrim, 10);
                    if (isSaveMove(board, row, col, move)) {

                        // make the move
                        board[row][col] = move;
                        if (isValidSudoku(board, col + 1)) {
                            return true;
                        }
                        // backtrack if wasn't a valid solution
                        board[row][col] = '.';
                    }

                }
            }
        }


        return false;
    }

    private boolean isSaveMove(char[][] board, int row, int col, char move) {

        // 1. Each row must contain the digits 1-9 without repetition.
        Set<Character> usedRowValues = new HashSet<>();
        usedRowValues.add(move);
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.' && !usedRowValues.add(board[row][i])) {
                return false;
            }
        }

        // 2. Each column must contain the digits 1-9 without repetition.
        Set<Character> usedColumnValues = new HashSet<>();
        usedColumnValues.add(move);
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && !usedColumnValues.add(board[i][col])) {
                return false;
            }
        }

        // 3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
        int gridRow = row / 3;
        int gridCol = col / 3;
        Set<Character> usedGridValues = new HashSet<>();
        usedGridValues.add(move);
        for (int i = gridRow; i < gridRow + 3; i++) {
            for (int j = gridCol; j < gridCol + 3; j++) {
                if (board[i][j] != '.' && !usedGridValues.add(board[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }

}
