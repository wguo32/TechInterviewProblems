class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                array[j] = array[j - 1] + array[j];
            }
        }
        return array[n - 1];
    }
}
