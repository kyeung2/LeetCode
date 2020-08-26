package io.nimbus.leetcode.queueandstack.conclusion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1388/
 */
public class ZeroOneMatrix {


    // I was close to this one but didn't quite get the solution. I recognised that you need a BFS for the solution
    // but I was 1 centric rather than 0 centric. The intuition is to set the other values (the ones), to be
    // Integer.MAX_VALUE and reducing this value by +1 its neighbour as to spread out.
    public int[][] updateMatrix(int[][] matrix) {

        // trying not to mutate argument. Not part of the exercise but good practice.
        int[][] res = new int[matrix.length][];
        int columnLength = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int row = 0; row < matrix.length; row++) {
            res[row] = new int[columnLength];
            Arrays.fill(res[row], Integer.MAX_VALUE);
            for (int column = 0; column < columnLength; column++) {
                if (matrix[row][column] == 0) {
                    res[row][column] = 0;
                    queue.offer(new int[]{row, column});
                }
            }
        }

        // at this point all the cells in the queue are for the 0 values, and the res[][] is filled with 0s and
        // Integer.MAX_VALUE.
        bfs(res, queue);

        return res;
    }

    private void bfs(int[][] res, Queue<int[]> queue) {

        int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            for (int[] delta : deltas) {

                int r = cell[0] + delta[0];
                int c = cell[1] + delta[1];

                // if out of bounds OR
                // the neighbour is already <= current +1
                // since the cells that are not zero are initialised to be Integer.MAX_VALUE this ensures processing
                // doesn't repeat itself.
                if (r < 0 || c < 0 || r == res.length || c == res[0].length ||
                        res[r][c] <= res[cell[0]][cell[1]] + 1) continue;

                // +1 to the neighbour res[r][c], recalling that the queue is originally full of 0s there for 0+1=1
                res[r][c] = res[cell[0]][cell[1]] + 1;
                queue.offer(new int[]{r, c});
            }
        }
    }

    public static void main(String[] args) {
        ZeroOneMatrix zeroOneMatrix = new ZeroOneMatrix();

        int[][] matrix = {{0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}};

        int[][] res = zeroOneMatrix.updateMatrix(matrix);
        printMatrix(matrix);
        System.out.println("---------");
        printMatrix(res);
    }

    private static void printMatrix(int[][] res) {
        for (int[] row : res) {
            System.out.println(Arrays.toString(row));
        }
    }

}