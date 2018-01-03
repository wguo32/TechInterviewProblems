/**
find all the paths from upper left corner to bottom right corner, for each path
there is a min value, return the max of these min values
[8, 4, 7]
[6, 5, 9]
three path：
8-4-7-9 min: 4
8-4-5-9 min: 4
8-6-5-9 min: 5
return: 5
*/

public class MaxMinPath {
    public static int path(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];

        // initialize dp
        for(int i = 1; i < m; i++) {
            dp[i][0] = Math.min(matrix[i][0], dp[i - 1][0]);
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.min(matrix[0][i], dp[0][i - 1]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(matrix[i][j],
                            Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{
                        {8,4,3,5},
                        {6,5,9,8},
                        {7,2,3,6}
                        } ;
        System.out.println(path(matrix));
    }
}
