/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
 // check if destination is reached after offering onto queue, i.e. after polling off the queue

public class Solution {
    /*
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */
    int[][] dir = {{1, 2},{1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        int path = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (point.x == destination.x && point.y == destination.y) {
                    return path;
                }
                for (int j = 0; j < 8; j++) {
                    int newX = point.x + dir[j][0];
                    int newY = point.y + dir[j][1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        // if (newX == destination.x && newY == destination.y) {
                        //     return path;
                        // }
                        if (visited[newX][newY] || grid[newX][newY]) {
                            continue;
                        }
                        queue.offer(new Point(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
            // if source is destination, path should be 0, so path should be increased at end of the while loop
            path++;
        }
        return -1;
    }
}

// check if destination is reached before offering onto queue
/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */

 public class Solution {
     /*
      * @param grid: a chessboard included 0 (false) and 1 (true)
      * @param source: a point
      * @param destination: a point
      * @return: the shortest path
      */
     int[][] dir = {{1, 2},{1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
     public int shortestPath(boolean[][] grid, Point source, Point destination) {
         if (grid == null || grid.length == 0 || grid[0].length == 0) {
             return -1;
         }
         int m = grid.length;
         int n = grid[0].length;
         boolean[][] visited = new boolean[m][n];

         Queue<Point> queue = new LinkedList<>();
         queue.offer(source);
         int path = 0;
         if (source.x == destination.x && source.y == destination.y) {
             return 0;
         }
         while (!queue.isEmpty()) {
             int size = queue.size();
             path++;
             for(int i = 0; i < size; i++) {
                 Point point = queue.poll();
                 // if (point.x == destination.x && point.y == destination.y) {
                 //     return path;
                 // }
                 for (int j = 0; j < 8; j++) {
                     int newX = point.x + dir[j][0];
                     int newY = point.y + dir[j][1];
                     if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                         if (newX == destination.x && newY == destination.y) {
                             return path;
                         }
                         if (visited[newX][newY] || grid[newX][newY]) {
                             continue;
                         }
                         queue.offer(new Point(newX, newY));
                         visited[newX][newY] = true;
                     }
                 }
             }
             // path++;
         }
         return -1;
     }
 }
