/**
DFS recursive approach
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
          return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
              maxArea = Math.max(maxArea, helper(i, j, grid));
            }
          }
        }
        return maxArea;
    }

    public int helper(int i, int j, int[][] grid) {
      if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
        return 0;
      }
      grid[i][j] = 0;
      return 1 + helper(i - 1, j, grid) + helper(i, j + 1, grid) + helper(i + 1, j, grid) + helper(i, j - 1, grid);
    }
}
