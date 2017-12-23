/**
BFS
*/
class Coordinate {
  int x;
  int y;
  Coordinate(int a, int b) {
    this.x = a;
    this.y = b;
  }
}
class Solution {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int m = grid.length, n = grid[0].length, count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          bfsHelper(i, j, grid);
          count++;
        }
      }
    }
    return count;
  }

  public void bfsHelper(int a, int b, char[][] grid) {
    int[] deltaX = {-1, 0, 1, 0};
    int[] deltaY = {0, 1, 0, -1};

    Queue<Coordinate> queue = new LinkedList<>();
    queue.offer(new Coordinate(a, b));

    while (!queue.isEmpty()) {
      Coordinate cell = queue.poll();

      // search its 4 neighbors
      for (int i = 0; i < 4; i++) {
        Coordinate neighbor = new Coordinate(cell.x + deltaX[i], cell.y + deltaY[i]);
        if (isInBound(neighbor, grid) && grid[neighbor.x][neighbor.y] == '1') {
          queue.offer(neighbor);
          grid[neighbor.x][neighbor.y] = '0';
        }
      }
    }
  }

  private boolean isInBound(Coordinate cell, char[][] grid) {
    return cell.x >= 0 && cell.y >= 0 && cell.x < grid.length && cell.y < grid[0].length;
  }
}


/**
resursive approach
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
