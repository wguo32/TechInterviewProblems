class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
