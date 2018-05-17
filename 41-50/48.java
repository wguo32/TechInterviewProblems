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
