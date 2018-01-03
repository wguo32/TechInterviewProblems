/**
1 ->  wall
0 -> empty space

This problem is different from rat in a maze. The rolling ball won't stop before
it hits a wall.
*/

class Solution {
    int[][] dir = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            if (pair[0] == destination[0] && pair[1] == destination[1]) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int newX = pair[0] + dir[i][0];
                int newY = pair[1] + dir[i][1];
                while((newX >= 0 && newX < maze.length && newY >= 0 && newY < maze[0].length) && maze[newX][newY] == 0) {
                    newX += dir[i][0];
                    newY += dir[i][1];
                }

                if (!visited[newX - dir[i][0]][newY - dir[i][1]]) {
                    queue.offer(new int[] {newX - dir[i][0], newY - dir[i][1]});
                    visited[newX - dir[i][0]][newY - dir[i][1]] = true;
                }
            }
        }
        return false;
    }
}
