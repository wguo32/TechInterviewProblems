// use memoization
class Solution {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] nums2 = new int [len +  2];
        int n = 1;
        for (int num : nums) {
            nums2[n++] = num;
        }
        nums2[0] = 1;
        nums2[n] = 1;

        int[][] dp = new int[len + 2][len + 2];
        return helper(nums2, dp, 1, len);
    }
    private int helper(int[] nums2, int[][] memo, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (memo[left][right] > 0) {
            return memo[left][right];
        }
        for (int i = left; i <= right; i++) {
            memo[left][right] = Math.max(memo[left][right],
                                helper(nums2, memo, left, i - 1) +
                                helper(nums2, memo, i + 1, right) +
                                nums2[left - 1] * nums2[i] * nums2[right + 1]);
        }
        return memo[left][right];
    }
}


// for loops
class Solution {
    public int maxCoins(int[] nums) {
        int[] nums2 = new int[nums.length + 2];
        int n = 1;
        for (int num : nums)  {
            if (num > 0) {
                nums2[n++] = num;
            }
        }
        nums2[0] = 1;
        nums2[n++] = 1;

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k) {
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                    nums2[left] * nums2[i] * nums2[right] + dp[left][i] + dp[i][right]);
            }
        }
        return dp[0][n - 1];
    }
}
