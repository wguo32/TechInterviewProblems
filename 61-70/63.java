class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[] array = new int[col];

        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            array[i] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j > 0){
                    array[j] = array[j - 1] + array[j];
                }
                if (obstacleGrid[i][j] == 1) {
                    array[j] = 0;
                }
            }
        }
        return array[col - 1];
    }
}
