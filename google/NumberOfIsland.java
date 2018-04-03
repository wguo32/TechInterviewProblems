// BFS
class Solution {
    class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(char[][] grid) {
        int num = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return num;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    grid[i][j] =  '0';
                    Queue<Position> queue = new LinkedList<>();
                    queue.offer(new Position(i, j));
                    while (!queue.isEmpty()) {
                        Position p = queue.poll();
                        if (p.x - 1 >= 0 && grid[p.x - 1][p.y] == '1') {
                            queue.offer(new Position(p.x - 1, p.y));
                            grid[p.x - 1][p.y] = '0';
                        }
                        if (p.y + 1 < grid[0].length && grid[p.x][p.y + 1] == '1') {
                            queue.offer(new Position(p.x, p.y + 1));
                            grid[p.x][p.y + 1] = '0';
                        }
                        if (p.x + 1 < grid.length && grid[p.x + 1][p.y] == '1') {
                            queue.offer(new Position(p.x + 1, p.y));
                            grid[p.x + 1][p.y] = '0';
                        }
                        if (p.y - 1 >= 0 && grid[p.x][p.y - 1] == '1') {
                            queue.offer(new Position(p.x, p.y - 1));
                            grid[p.x][p.y - 1] = '0';
                        }
                    }

                }
            }
        }
        return num;
    }
}

// DFS
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int num = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 ||
            j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
    }
}
