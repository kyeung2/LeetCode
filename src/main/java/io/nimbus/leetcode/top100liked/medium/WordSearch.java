package io.nimbus.leetcode.top100liked.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {


    public static void main(String[] args) {


        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(new WordSearch().exist(board, word));
    }


    public boolean exist(char[][] board, String word) {

        char first = word.charAt(0);
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {


                // if we find a starting point, start recursively snaking.
                //TODO again, the short solution doesn't care if its invalid or not. makes the move blindly then checks
                if (board[row][column] == first) {
                    Set<Point> visitedPoints = new HashSet<>();
                    Point p = new Point(row, column);
                    visitedPoints.add(p);
                    if (snake(board, word, p, 0, visitedPoints)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean snake(char[][] board, String word, Point p, int characterIndex, Set<Point> visitedPoints) {

        if (visitedPoints.size() == word.length()) {
            return true;
        }

        //Get the valid moves. then backtrack style.
        char nextChar = word.charAt(characterIndex + 1);

        // TODO the short solution uses a 4 way recursion, and doesn't care if its valid or not. Event going out of bounds.
        for (Point nextMove : getValidMoves(board, p, nextChar)) {
            if (!visitedPoints.contains(nextMove)) {
                //TODO the short solution used a backtracking way but on the original board so no need for the visited points
                visitedPoints.add(nextMove);
                if (snake(board, word, nextMove, characterIndex + 1, visitedPoints)) {
                    return true;
                }
                visitedPoints.remove(nextMove);
            }
        }


        return false;
    }

    private List<Point> getValidMoves(char[][] board, Point p, char nextChar) {

        List<Point> validMoves = new ArrayList<>();

        // above
        if (p.row != 0 && board[p.row - 1][p.column] == nextChar) {
            validMoves.add(new Point(p.row - 1, p.column));
        }
        // right
        if (p.column != board[0].length - 1 && board[p.row][p.column + 1] == nextChar) {
            validMoves.add(new Point(p.row, p.column + 1));
        }

        // below
        if (p.row != board.length - 1 && board[p.row + 1][p.column] == nextChar) {
            validMoves.add(new Point(p.row + 1, p.column));
        }
        // left
        if (p.column != 0 && board[p.row][p.column - 1] == nextChar) {
            validMoves.add(new Point(p.row, p.column - 1));
        }

        return validMoves;
    }


    public static class Point {
        int row, column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return row == point.row && column == point.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "row=" + row +
                    ", column=" + column +
                    '}';
        }
    }
}
