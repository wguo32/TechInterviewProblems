// DP with O(N) space
class Solution {
    public int rob(int[] num) {
        int[][] dp = new int[num.length + 1][2];
        for (int i = 1; i <= num.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = num[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[num.length][0], dp[num.length][1]);
    }
}

// with O(1) space
class Solution {
    public int rob(int[] num) {
        int preMax = 0;
        int curMax = 0;
        for (int number : num) {
            int temp = curMax;
            curMax = Math.max(preMax + number, curMax);
            preMax = temp;
        }
        return curMax;
    }
}
