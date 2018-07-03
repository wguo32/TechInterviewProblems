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


// use BFS
class Solution {
    class Point {
        int x;
        int y;
        Point(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(i, j, grid);
                    num++;
                }
            }
        }
        return num;
    }

    private void bfs(int i, int j, char[][] grid) {
        int[] deltaX = {-1, 0, 1, 0};
        int[] deltaY = {0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));
        grid[i][j] = '0';

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int k = 0; k < 4; k++) {
                int newX = p.x + deltaX[k];
                int newY = p.y + deltaY[k];
                if (inBound(newX, newY, grid) && grid[newX][newY] == '1') {
                    queue.offer(new Point(newX, newY));
                    grid[newX][newY] = '0';
                }
            }
        }
    }

    private boolean inBound(int i, int j, char[][] grid) {
        return i >=0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
