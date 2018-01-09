class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int maxCur = nums[0], minCur = nums[0];
        int maxP = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                maxCur = Math.max(nums[i], maxCur * nums[i]);
                minCur = Math.min(nums[i], minCur * nums[i]);
            } else {
                int temp = maxCur;
                maxCur = Math.max(nums[i], minCur * nums[i]);
                minCur = Math.min(nums[i], temp * nums[i]);
            }
            maxP = Math.max(maxP, maxCur);
        }
        return maxP;
    }
}
