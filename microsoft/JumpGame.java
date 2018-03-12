/* backtracking version(though it could not pass leetcode test cases,
this is a good practice for backtracking problems) */

class Solution {
    public boolean canJump(int[] nums) {
        return canJumpFrom(0, nums);
    }

    private boolean canJumpFrom(int start, int[] nums) {
        if (start >= nums.length - 1) {
            return true;
        }
        int jumpRange = Math.min(start + nums[start], nums.length - 1);
        for (int i = start + 1; i <= jumpRange; i++) {
            if (canJumpFrom(i, nums)) {
                return true;
            }
        }
        return false;
    }
}

/* Dynamic programming top-down approach using memoization, this is an optimization of backtracking.
    this also cause stack overflow on leetcode.
*/
class Solution {
    public boolean canJump(int[] nums) {
        // -1 means not reachable, 1 means reachable, 0 mean not decided yet
        int[] memo = new int[nums.length];
        return canJumpFrom(0, nums, memo);
    }
    private boolean canJumpFrom(int start, int[] nums, int[] memo) {
        if (memo[start] != 0) {
            if (memo[start] = 1) {
                return true;
            }
            return false;
        }
        int jumpRange = Math.min(start + nums[start], nums.length - 1);
        for (int i = start + 1; i <= jumpRange; i++) {
            if (canJumpFrom(i, nums, memo)) {
                memo[i] = 1;
                return true;
            }
        }
        memo[start] = -1;
        return false;
    }
}
