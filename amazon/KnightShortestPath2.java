/**
http://www.lintcode.com/en/problem/knight-shortest-path-ii/#
*/
public class Solution {
    /*
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    int[][] dir = {{1, 2}, {-1, 2},{2, 1}, {-2, 1}};
    public int shortestPath2(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int  i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;
        for (int j = 1; j < n; j++) {
            for(int i = 0; i < m; i++) {
                if (!grid[i][j]) {
                    if (i >= 1 && j >= 2 && grid[i - 1][j - 2] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 2] + 1);
                    }
                    if (i + 1 < m && j >= 2 && dp[i + 1][j - 2] != Integer.MAX_VALUE)
                      dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 2] + 1);
                    if (i >= 2 && j >= 1 && dp[i - 2][j - 1] != Integer.MAX_VALUE)
                        dp[i][j] = Math.min(dp[i][j], f[i - 2][j - 1] + 1);
                    if (i + 2 < m && j >= 1 && dp[i + 2][j - 1] != Integer.MAX_VALUE)
                        dp[i][j] = Math.min(dp[i][j], dp[i + 2][j - 1] + 1);
                }
            }
        }
        if (dp[m - 1][n - 1] == Integer.MAX_VALUE) {
            return  -1;
        }
        return dp[m - 1][n - 1];
    }
}
