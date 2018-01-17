// use bit manipulation
class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int neighbors = getCount(board, i, j);
                if (board[i][j] == 1 && neighbors >= 2 && neighbors <= 3) {
                    board[i][j] = 3; // 01 -> 11
                }
                if (board[i][j] == 0 && neighbors == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int getCount(int[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        int count = 0;
        for (int p = Math.max(i - 1, 0); p < Math.min(i + 2, m); p++) {
            for (int q = Math.max(j - 1, 0); q < Math.min(j + 2, n); q++) {
                count += board[p][q] & 1;
            }
        }
        count -= board[i][j] & 1;
        return count;
    }
}


// class Solution {
//     int[] deltaX = {0, 1, 1, 1, 0, -1, -1, -1};
//     int[] deltaY = {1, 1, 0, -1, -1, -1, 0, 1};
//     public void gameOfLife(int[][] board) {
//         if (board == null || board.length == 0 || board[0].length == 0) {
//             return;
//         }
//
//         int m = board.length, n = board[0].length;
//         int[][] change = new int[m][n];
//
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 int neighbors = getCount(board, i, j);
//                 if (board[i][j] == 0) {
//                     if (neighbors == 3) {
//                         change[i][j] = 1;
//                     }
//                 } else {
//                     if (neighbors < 2) {
//                         change[i][j] = 0;
//                     } else if (neighbors == 2 || neighbors == 3) {
//                         change[i][j] = 1;
//                     } else {
//                         change[i][j] = 0;
//                     }
//                 }
//             }
//         }
//     }
//
//     private int getCount(int[][] board, int i, int j) {
//         int count = 0, m = board.length, n = board[0].length;
//         for(int k = 0; k < 8; k++) {
//             int newX = deltaX[k] + i;
//             int newY = deltaY[k] + j;
//             if (newX >=0 && newX < m && newY >= 0 && newY < n) {
//                 if (board[newX][newY] == 1) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }
