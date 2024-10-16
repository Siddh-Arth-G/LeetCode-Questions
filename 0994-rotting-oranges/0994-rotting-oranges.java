class Solution {

    /**
     * Runtime 1 ms: Beats 99.99% of users with Java
     * Memory 41.72 MB: Beats 96.29% of users with Java
     * Time: O(M x N)
     * Space: O(M x N)
     */
    // 2 1 2
    // 0 1 1
    // 1 0 1
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        int[][] newGrid = new int[ROWS + 2][COLS + 2];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                newGrid[r + 1][c + 1] = grid[r][c];
            }
        }

        int minutes = 0;

        boolean done = false;

        while (!done) {
            done = true;
            boolean hasGood = false;
            for (int r = 1; r <= ROWS; r++) {
                for (int c = 1; c <= COLS; c++) {
                    if (newGrid[r][c] == 1) {
                        hasGood = true;
                        if (hasBadNeighbor(r, c, newGrid)) {
                            newGrid[r][c] = 3;
                            done = false;
                        }
                    }
                }
            }

            if (!done) {
                minutes++;
                for (int r = 1; r <= ROWS; r++) {
                    for (int c = 1; c <= COLS; c++) {
                        if (newGrid[r][c] == 3) {
                            newGrid[r][c] = 2;
                        }
                    }
                }
            }

            if (hasGood && done) {
                return -1;
            }
        }

        return minutes;
    }

    boolean hasBadNeighbor(int row, int col, int[][] grid) {
        //     left                       top                        right                      bottom
        return grid[row][col - 1] == 2 || grid[row - 1][col] == 2 || grid[row][col + 1] == 2 || grid[row + 1][col] == 2;
    }
}