class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int curSum = nums[start] + nums[end] + nums[i];
                if (curSum < target) {
                    start++;
                } else {
                    end--;
                }
                if (Math.abs(curSum - target) < Math.abs(sum - target)) {
                    sum = curSum;
                }
            }
        }
        return sum;
    }
}
