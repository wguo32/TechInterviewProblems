// use memoization top down approach
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
public class Solution {
    public int maxCoins(int[] nums) {
        int dp[][] = new int[nums.length][nums.length];

        for (int len = 1; len <= nums.length; len++) { // length of subarray
            for (int i = 0; i <= nums.length - len; i++) { // start index of subarray
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    //leftValue/rightValue is initially 1. If there is element on
                    // left/right of k then left/right value will take that value.
                    int leftValue = 1;
                    int rightValue = 1;
                    if (i != 0) {
                        leftValue = nums[i-1];
                    }
                    if (j != nums.length -1) {
                        rightValue = nums[j+1];
                    }

                    // left is initially 0. If k is i then left will
                    //stay 0 otherwise it gets value dp[i][k-1]
                    // right is similarly 0 initially. if k is j then right will
                    //stay 0 otherwise it will get value dp[k+1][j]
                    int left = 0;
                    int right = 0;
                    if (i != k) {
                        left = dp[i][k-1];
                    }
                    if (j != k) {
                        right = dp[k+1][j];
                    }
                    dp[i][j] = Math.max(leftValue * nums[k] * rightValue + left + right,
                            dp[i][j]);
                }
            }
        }
        return dp[0][nums.length - 1];
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
