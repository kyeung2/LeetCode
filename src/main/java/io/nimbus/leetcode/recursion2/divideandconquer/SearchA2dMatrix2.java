package io.nimbus.leetcode.recursion2.divideandconquer;

/**
 * https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2872/
 */
public class SearchA2dMatrix2 {

    /*
    so this solution uses indices and not array copying as I did. Definitely more efficient as out of bounds can be checked
    before using the indices in the next iteration.

    I tried to search 3 sub-matrices, this solution searches the same space, but splitting into a rectangle and a square achieving the same result with less complexity

     */

    int[][] matrix;
    int target;

    // nice solution found at https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2872/discuss/148444/Java-Solution-using-Binary-Search-(with-comments)-(96)
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        if (matrix.length == 0)
            return false;
        return helper(0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    /**
     * @param rowStart, row coordinate of top left element of the matrix
     * @param colStart, column coordinate of top left element of the matrix
     * @param rowEnd,   row coordinate of bottom right element of the matrix
     * @param colEnd,   column coordinate of bottom right element of the matrix
     */
    private boolean helper(int rowStart, int colStart, int rowEnd, int colEnd) {
        if (rowEnd < rowStart || colEnd < colStart || rowStart >= matrix.length || colStart >= matrix[0].length || rowEnd < 0 || colEnd < 0)
            return false;
        int rowMid = (rowEnd - rowStart) / 2 + rowStart;
        int colMid = (colEnd - colStart) / 2 + colStart;
        // Check the middle element of the matrix, if not found,
        // recursively call on sub matrices where
        // the value could still exist.
        // You will realize that the resultant possible places will
        // form a L shape on the original matrix.
        // This L shape can be broken down into 2 matrices.
        // If number found in any of the 2 matrices, we return true.

        /*
         zone 1      zone 2
         *  *  *  * | *  *  *  *
         *  *  *  * | *  *  *  *
         *  *  *  * | *  *  *  *
         *  *  *  * | *  *  *  *
         -----------------------
         *  *  *  * | *  *  *  *
         *  *  *  * | *  *  *  *
         *  *  *  * | *  *  *  *
         *  *  *  * | *  *  *  *
         zone 3      zone 4
         */

        int valueMid = this.matrix[rowMid][colMid];
        if (target == valueMid)
            return true;
        else if (target < valueMid)
            // discard zone 4 as all elements in zone 4 are > target, so inverted L shape
            return helper(rowStart, colStart, rowEnd, colMid - 1) || helper(rowStart, colMid, rowMid - 1, colEnd);
        else
            // discard zone 1 as all elements are < target, so a mirrored L shape.
            return helper(rowStart, colMid + 1, rowEnd, colEnd) || helper(rowMid + 1, colStart, rowEnd, colMid);
    }


    static class MyAttempt {
        // attempted but doesn't pass for all scenarios. Don't have the energy to continue...
        public boolean searchMatrix(int[][] matrix, int target) {

            // if it is empty you will not be able to find
            if (matrix.length == 0 || matrix[0].length == 0)
                return false;

            if (matrix.length == 1 && matrix[0].length == 1)
                return matrix[0][0] == target;

            int rowMid = matrix.length / 2;
            int colMid = matrix[0].length / 2;
            int midValue = matrix[rowMid][colMid];

            // found return
            if (target == midValue)
                return true;
                // if the target is smaller then we can disregard the bottom right
            else if (target < midValue) {

                int[][] topLeft = copy2DArray(matrix, 0, rowMid == 0 ? rowMid + 1 : rowMid, 0, colMid == 0 ? colMid + 1 : colMid);
                if (searchMatrix(topLeft, target))
                    return true;
                int[][] bottomLeft = copy2DArray(matrix, rowMid + 1, matrix.length, 0, colMid == 0 ? colMid + 1 : colMid);
                if (searchMatrix(bottomLeft, target))
                    return true;
                int[][] topRight = copy2DArray(matrix, 0, rowMid == 0 ? rowMid + 1 : rowMid, colMid + 1, matrix[0].length);
                return searchMatrix(topRight, target);
            }
            // if the target is greater then we can disregard the top left
            else {
                int[][] bottomLeft = copy2DArray(matrix, rowMid + 1, matrix.length, 0, colMid == 0 ? colMid + 1 : colMid);
                if (searchMatrix(bottomLeft, target))
                    return true;
                int[][] topRight = copy2DArray(matrix, 0, rowMid == 0 ? rowMid + 1 : rowMid, colMid + 1, matrix[0].length);
                if (searchMatrix(topRight, target))
                    return true;
                int[][] bottomRight = copy2DArray(matrix, rowMid + 1, matrix.length, colMid + 1, matrix[0].length);
                return searchMatrix(bottomRight, target);
            }
        }


        public static int[][] copy2DArray(int[][] matrix, int rowStart, int rowEnd, int columnStart, int columnEnd) {
            int[][] ret = new int[rowEnd - rowStart][];
            for (int i = 0; i < rowEnd - rowStart; i++) {

                int[] row = matrix[i + rowStart];
                ret[i] = new int[columnEnd - columnStart];
                System.arraycopy(row, columnStart, ret[i], 0, columnEnd - columnStart);
            }

            return ret;
        }
    }


    public static void main(String[] args) {

        SearchA2dMatrix2 s = new SearchA2dMatrix2();

        // base cases
        System.out.println(s.searchMatrix(new int[][]{}, 2));
        System.out.println(s.searchMatrix(new int[][]{{}}, 2));
        // exactly at midpoint return.
        System.out.println(s.searchMatrix(new int[][]{
                {1, 1, 1},
                {1, 2, 1},
                {1, 1, 1}}, 2));
        // top-left quadrant
        System.out.println(s.searchMatrix(new int[][]{
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}}, 1));
        //bottom-left quadrant
        System.out.println(s.searchMatrix(new int[][]{
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}}, 3));
        // top-right
        System.out.println(s.searchMatrix(new int[][]{
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}}, 7));
        // bottom-right
        System.out.println(s.searchMatrix(new int[][]{
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}}, 9));

        System.out.println(s.searchMatrix(new int[][]{
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}}, 10));

        System.out.println(s.searchMatrix(new int[][]{
                {-1, 3}}, -1));

        System.out.println(s.searchMatrix(new int[][]{
                {-1}}, -1));

        System.out.println(s.searchMatrix(new int[][]{
                {-5}}, -10));

    }
}
