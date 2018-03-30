class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            int j = 1;
            while (i - j * j >= 0) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
                j++;
            }
        }
        return dp[n];
    }
}
