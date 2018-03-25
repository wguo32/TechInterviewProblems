class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[nums.length];
    }
}


// space complexity O(1)
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preMax = 0;
        int curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = curMax;
            curMax = Math.max(curMax, preMax + nums[i]);
            preMax = temp;
        }
        return curMax;
    }
}
