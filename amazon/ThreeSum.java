class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(result, nums, i + 1, nums.length - 1, -nums[i]);
        }
        return result;
    }

    private void twoSum(List<List<Integer>> result, int[] nums, int start, int end, int target) {
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                result.add(Arrays.asList(-target, nums[start], nums[end]));
                start++;
                end--;
                while (start < end && nums[start - 1] == nums[start]) {
                    start++;
                }
                while (start < end && nums[end + 1] == nums[end]) {
                    end--;
                }
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }
        }
    }
}
