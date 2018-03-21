class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int minR = 0, maxR = n - 1;
        int minC = 0, maxC = n - 1;
        int num = 1;
        while (minR <= maxR && minC <= maxC) {
            for (int i = minC; i <= maxC; i++) {
                matrix[minR][i] = num++;
            }
            minR++;
            for (int i = minR; i <= maxR; i++) {
                matrix[i][maxC] = num++;
            }
            maxC--;
            for (int i = maxC; i>= minC; i--) {
                matrix[maxR][i] = num++;
            }
            maxR--;
            for (int i = maxR; i >= minR; i--) {
                matrix[i][minC] = num++;
            }
            minC++;
        }
        return matrix;
    }
}
