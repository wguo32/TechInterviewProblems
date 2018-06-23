class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, -nums[i], i + 1, nums.length - 1, result);
        }
        return result;
    }

    private void twoSum(int[] nums, int target, int start, int end, List<List<Integer>> result) {
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                result.add(Arrays.asList(-target, nums[start], nums[end]));
                start++;
                end--;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
                while(start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
    }
}
