class Solution {

    public void gameOfLife(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        // 8 directions
        int[][] dir = {
            {-1,-1},{-1,0},{-1,1},
            {0,-1},        {0,1},
            {1,-1},{1,0},{1,1}
        };

        // Step 1: Mark changes
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                int live = 0;

                // Count live neighbours
                for (int[] d : dir) {

                    int r = i + d[0];
                    int c = j + d[1];

                    if (r >= 0 && r < rows &&
                        c >= 0 && c < cols &&
                        (board[r][c] == 1 || board[r][c] == -1)) {

                        live++;
                    }
                }

                // Alive -> Dead
                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = -1;
                }

                // Dead -> Alive
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 2;
                }
            }
        }

        // Step 2: Final conversion
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j] == -1)
                    board[i][j] = 0;

                if (board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }
}