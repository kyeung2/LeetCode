package io.nimbus.leetcode.queueandstack.stackanddfs;


/**
 * https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1380/
 * <p>
 * Although this exercise was previously completed. It is good to reimplement using the template of DFS and using its
 * nomenclature.
 */
public class NumberOfIslands {


    /*

    template given from the text, "visited" an important concept that should be added to the code.

    boolean DFS(Node cur, Node target, Set<Node> visited) {
        return true if cur is target;
        for (next : each neighbor of cur) {
            if (next is not in visited) {
                add next to visted;
                return true if DFS(next, target, visited) == true;
            }
        }
        return false;
    }

     */

    public int numIslands(char[][] grid) {
        if (grid == null) return 0;
        int islands = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        return islands;
    }

    void dfs(char[][] grid, int i, int j) {

        // invalid neighbours or no need to visit coordinates terminate recursion.
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == '0')
            return;

        // essentially marking as visited or no need to visit.
        grid[i][j] = '0';

        // visit neighbours
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
