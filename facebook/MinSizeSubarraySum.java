// time complexity O(N^2)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minSize = Integer.MAX_VALUE;
        int sums[] = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < sums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sums[i] - sums[j] >= s) {
                    minSize = Math.min(minSize, i - j);
                }
            }
        }
        if (minSize == Integer.MAX_VALUE) {
            return 0;
        }
        return minSize;
    }
}

// linear time complexity with slide window
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        for (int right = 0, left = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left <= right && sum >= s) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
