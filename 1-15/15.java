class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(-nums[i], i + 1, result, nums);
        }
        return result;
    }

    private void twoSum(int target, int start, List<List<Integer>> result, int[] nums) {
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                result.add(Arrays.asList(-target, nums[start], nums[end]));
                start++;
                end--;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end + 1]) {
                    end --;
                }
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
    }
}
