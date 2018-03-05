class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] presum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }

        int count = 0;
        for (int i = 1; i < len + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (presum[i] - presum[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
