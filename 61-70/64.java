class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length, col = grid[0].length;
        int[] array = new int[col];

        array[0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            array[i] = grid[0][i] + array[ i - 1];
        }

        for (int i = 1; i < row; i++) {
            array[0] += grid[i][0];
            for (int j = 1; j < col; j++) {
                array[j] = Math.min(array[j - 1], array[j]) + grid[i][j];
            }
        }
        return array[col - 1];
    }
}
