class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] track = new int[m][n];
        track[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            track[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            track[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    track[i][j] = track[i - 1][j] + track[i][j - 1];
                }
            }
        }
        return track[m - 1][n - 1];
    }
}


// with better space complexity
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] track = new int[n];
        track[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    track[j] = 0;
                } else if (j > 0){
                    track[j] += track[j - 1];
                }
            }
        }
        return track[n - 1];
    }
}
