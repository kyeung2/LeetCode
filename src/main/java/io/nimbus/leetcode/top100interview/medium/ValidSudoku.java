package io.nimbus.leetcode.top100interview.medium;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {


    public static void main(String[] args) {

        // valid
        {
            char[][] board = {
                    {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                    , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                    , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                    , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                    , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                    , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                    , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                    , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                    , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            };

            System.out.println(new ValidSudoku_my_attempt().isValidSudoku(board));
        }
        // invalid
        {
            char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                    , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                    , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                    , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                    , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                    , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                    , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                    , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                    , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
            System.out.println(new ValidSudoku_my_attempt().isValidSudoku(board));
        }

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

            System.out.println(new ValidSudoku().isValidSudoku(board));
        }
    }


    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new LinkedHashSet<>();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }


}
