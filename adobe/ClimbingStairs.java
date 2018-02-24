class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] table = new int[n];
        table[0] = 1;
        table[1] = 2;
        for (int i = 2; i < n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n - 1];
    }
}
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
