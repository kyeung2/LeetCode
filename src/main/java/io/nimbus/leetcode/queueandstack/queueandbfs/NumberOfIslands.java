package io.nimbus.leetcode.queueandstack.queueandbfs;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1374/
 */
public class NumberOfIslands {

    // couldn't think of a solution myself.
    // solution found at https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1374/discuss/56349/7-lines-Python-~14-lines-Java
    public int numIslands(char[][] grid) {

        if (grid == null) return 0;

        int islands = 0;
        char[][] mutableGrid = grid;// just to not mess with the original argument.
        for (int i = 0; i < mutableGrid.length; i++)
            for (int j = 0; j < mutableGrid[i].length; j++) {


                if (mutableGrid[i][j] == '1') {
                    sinkConnectedLand(mutableGrid, i, j);
                    islands++;
                }
            }
        return islands;
    }

    void sinkConnectedLand(char[][] mutableGrid, int i, int j) {

        // if array out of bounds or water return 0
        if (i < 0 || i == mutableGrid.length || j < 0 || j == mutableGrid[i].length || mutableGrid[i][j] == '0')
            return;

        // the importance is that all "connected" land, will be zeroed, turned into water 1->0. so the calling code will
        // only go into another recursive call on another piece of land.
        mutableGrid[i][j] = '0';// sink the 1 into a 0.

        // repeat for adjacent cardinal positions
        sinkConnectedLand(mutableGrid, i + 1, j);
        sinkConnectedLand(mutableGrid, i - 1, j);
        sinkConnectedLand(mutableGrid, i, j + 1);
        sinkConnectedLand(mutableGrid, i, j - 1);
    }


}
