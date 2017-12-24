/**
Problem can be found on lintcode http://www.lintcode.com/en/problem/two-sum-unique-pairs/
*/
public class Solution {
    public int twoSum6(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, count = 0;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                count++;
                i++;
                j--;
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}
