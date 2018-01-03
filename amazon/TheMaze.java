/**
0 -> this is a wall
1 -> empty space
9 -> you find the cheese!
*/
import java.util.LinkedList;
import java.util.Queue;
public class TheMaze {
    int[] deltaX = {-1, 0, 0 ,1};
    int[] deltaY = {0, 1, -1, 0};
    class Point {
        int x;
        int y;
        Point(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }
    public int solution(int[][] maze) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return 0;
        }
        if (maze[0][0] == 9) {
            return 0;
        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (maze[point.x][point.y] == 9) {
                return 1;
            } else if (maze[point.x][point.y] == 1) {
                for (int i = 0; i < 4; i++) {
                    int newX = point.x + deltaX[i];
                    int newY = point.y + deltaY[i];
                    if (newX >= 0 && newX < maze.length && newY >= 0 && newY < maze[0].length) {
                        queue.offer(new Point(newX, newY));
                    }
                }
                System.out.println("Current position:" + point.x + ", " + point.y);
                maze[point.x][point.y] = 0;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // int[][] matrix = {
        //     {1,1,0,1,1},
        //     {1,1,1,1,1},
        //     {1,0,1,1,1},
        //     {0,0,1,0,0},
        //     {9,1,1,1,1}
        // };
        int[][] matrix = {
            {1,1,0,1,1},
            {1,1,1,1,1},
            {1,0,1,1,1},
            {0,0,1,0,0},
            {1,1,0,1,9}
        };
        TheMaze maze = new TheMaze();
        System.out.println(maze.solution(matrix));
    }
}
