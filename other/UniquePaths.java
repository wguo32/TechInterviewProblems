class Solution {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < n; i++) {
            matrix[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[m - 1][n - 1];
    }
}

// space complexity O(min(m,n)) using two rows to keep path source

class Solution {
    public int uniquePaths(int m, int n) {
        int track[][] = new int[2][n];
        for (int i = 0; i < n; i++) {
            track[0][i] = 1;
        }
        track[1][0] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                track[i % 2][j] = track[i % 2][j - 1] + track[(i - 1) % 2][j];
            }
        }
        return track[(m - 1) % 2][n - 1];
    }
}

// even better space complexity, only keep one row in track

class Solution {
    public int uniquePaths(int m, int n) {
        int[] track = new int[n];
        for (int i = 0; i < n; i++) {
            track[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            int pre = 1;
            for (int j = 1; j < n; j++) {
                track[j] = track[j] + pre;
                pre = track[j];
            }
        }
        return track[n - 1];
    }
}
