/**
0 -> this is a wall
1 -> empty space
9 -> you find the cheese!
*/
import java.util.LinkedList;
import java.util.Queue;
public class TheMaze {
    int[][] dir = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    public int solution(int[][] maze) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return 0;
        }
        if (maze[0][0] == 9) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        maze[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            System.out.println("In the while loop");
            for (int i = 0; i < 4; i++) {
                int newX = point[0] + dir[i][0];
                int newY = point[1] + dir[i][1];

                if (newX >= 0 && newX < maze.length && newY >= 0 && newY < maze[0].length) {
                    System.out.println("In the for loop");

                    if (maze[newX][newY] == 9) {
                        return 1;
                    } else if (maze[newX][newY] == 1) {
                        queue.offer(new int[] {newX, newY});
                        maze[newX][newY] = 0;
                        System.out.println("Current position:" + newX+ ", " + newY);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,1,0,1,1},
            {1,1,1,1,1},
            {1,0,1,1,1},
            {0,0,1,0,0},
            {9,1,1,1,1}
        };
        // int[][] matrix = {
        //     {1,1,0,1,1},
        //     {1,1,1,1,1},
        //     {1,0,1,1,1},
        //     {0,0,1,0,0},
        //     {1,1,0,1,9}
        // };
        TheMaze maze = new TheMaze();
        System.out.println(maze.solution(matrix));
    }
}
