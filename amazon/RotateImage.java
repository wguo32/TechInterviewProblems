/**
Rotate the matrix clockwise by 90 degrees
*/
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int len = matrix.length;
        // transpose the matrix
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // for each row of the matrix, flip it around the middle coloum
        for (int i = 0; i < len; i++) {
            int start = 0, end = len - 1;
            while (start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }
}

/**
Rotate the matrix counter clockwise by 90 degrees
*/
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int len = matrix.length;
        // transpose the matrix
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // for each column of the matrix, flip it around the middle row
        for (int j = 0; j < len; j++) {
            int start = 0, end = len - 1;
            while (start < end) {
                int temp = matrix[start][j];
                matrix[start][j] = matrix[end][j];
                matrix[end][j] = temp;
                start++;
                end--;
            }
        }
    }
}
