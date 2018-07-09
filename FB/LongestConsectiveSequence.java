// with sorting and o(nlgn) time complexity
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int longest = 1;
        int curLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                if (nums[i] == nums[i - 1] + 1) {
                    curLen++;
                    longest = Math.max(longest, curLen);
                } else {
                    curLen = 1;
                }
            }
        }
        return longest;
    }
}
