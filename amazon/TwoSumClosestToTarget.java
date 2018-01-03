/**
The original problem is to find two containers such that sum of their capacity
is closest to a number.

http://www.lintcode.com/en/problem/two-sum-closest-to-target/#

*/
public class Solution {
    /*
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        Arrays.sort(nums);

        int start = 0, end = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        while (start < end) {
            if (nums[start] + nums[end] < target) {
                diff = Math.min(diff, target - nums[start] - nums[end]);
                start++;
            } else {
                diff = Math.min(diff, nums[start] + nums[end] - target);
                end--;
            }
        }
        return diff;
    }
}
