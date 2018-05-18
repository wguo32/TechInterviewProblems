// swap based
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        int n = matrix.length;
        while (n > 1) {
            for (int j = 0; j < n - 1; j++) {
                int temp = matrix[top][left + j];
                matrix[top][left + j] = matrix[bottom - j][left];
                matrix[bottom - j][left]  = matrix[bottom][right - j];
                matrix[bottom][right - j] = matrix[top + j][right];
                matrix[top + j][right] = temp;
            }
            top++;
            bottom--;
            left++;
            right--;
            n -= 2;
        }
    }
}

// transpose and flip
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            int start = 0, end = matrix.length - 1;
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
