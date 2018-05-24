class Solution {
    public int[][] generateMatrix(int n) {
        int minRow = 0, maxRow = n - 1;
        int minCol = 0, maxCol = n - 1;

        int[][] result = new int[n][n];
        int num = 1;
        while (minRow <= maxRow && minCol <= maxCol) {
            for (int i = minCol; i <= maxCol; i++) {
                result[minRow][i] = num;
                num++;
            }
            minRow++;

            for (int i = minRow; i <= maxRow; i++) {
                result[i][maxCol] = num;
                num++;
            }
            maxCol--;

            for (int i = maxCol; i >= minCol; i--) {
                result[maxRow][i] = num;
                num++;
            }
            maxRow--;

            for (int i = maxRow; i >= minRow; i--) {
                result[i][minCol] = num;
                num++;
            }
            minCol++;
        }
        return result;
    }
}
