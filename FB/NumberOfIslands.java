/**
resursive approach
1. DFS time complexity and space complexity are O(m * n)
2. For space complexity: if the grid is filled with islands, then the trace of visited cells
is like a curl.
*/
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
          return 0;
        }

        int m = grid.length, n = grid[0].length, count = 0;
        for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
            if (grid[i][j] == '1') {
              helper(i, j, grid);
              count++;
            }
          }
        }

        return count;
    }

    public void helper(int i, int j, char[][] grid) {
      // if the current cell is  0, there is no need to search its neighbors!!
      if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
        return;
      }

      grid[i][j] = '0';

      helper(i - 1, j, grid);
      helper(i + 1, j, grid);
      helper(i, j - 1, grid);
      helper(i, j + 1, grid);
    }
}
