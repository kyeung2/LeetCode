package io.nimbus.leetcode.queueandstack.conclusion;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1393/
 */
public class FloodFill {


    // pretty happy this one went smoothly, it was obvious that it should be a dfs.
    // I wanted to use a Stack implementation rather than a call stack implementation but remembering a pair
    // in Java isn't as smooth as it should be.
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image == null) return null;
        int currentColour = image[sr][sc];
        dfs(image, sr, sc, currentColour, newColor);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int currentColour, int newColor) {
        if (sr < 0 || sr == image.length || sc < 0 || sc == image[0].length || image[sr][sc] == newColor) return;

        if (image[sr][sc] == currentColour) {
            image[sr][sc] = newColor;
            // visit neighbours
            dfs(image, sr + 1, sc, currentColour, newColor);
            dfs(image, sr - 1, sc, currentColour, newColor);
            dfs(image, sr, sc + 1, currentColour, newColor);
            dfs(image, sr, sc - 1, currentColour, newColor);
        }
    }


    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] filled = floodFill.floodFill(image, 1, 1, 2);
        for (int[] row : filled) {
            System.out.println(Arrays.toString(row));
        }
    }

}
