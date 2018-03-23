class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        if (4 * nums[0] > target || 4 * nums[nums.length - 1] < target) {
            return result;
        }
        for (int i = 0; i < nums.length - 3; i++) {
            int first = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (4 * first > target) {
                break;
            }
            if (first + 3 * nums[nums.length - 1] < target) {
                continue;
            }
            if (4 * first == target && nums[i + 3] == first) {
                result.add(Arrays.asList(first, first, first, first));
                break;
            }
            threeSum(nums, i + 1, nums.length - 1, first, target - first, result);
        }
        return result;
    }

    private void threeSum(int[] nums, int start, int end, int first, int target,
                        List<List<Integer>> result) {
            if (3 * nums[start] > target || 3 * nums[end] < target) {
                return;
            }

            for (int i = start; i < end - 1; i++) {
                int second = nums[i];
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (3 * second > target) {
                    break;
                }
                if (second + 2 * nums[end] < target) {
                    continue;
                }
                if (3 * second == target && nums[i + 2] == second) {
                    result.add(Arrays.asList(first, second, second, second));
                    break;
                }
                twoSum(nums, i + 1, end, first, nums[i], target - second, result);
            }
    }

    private void twoSum(int[] nums, int start, int end, int first, int second, int target,
                    List<List<Integer>> result) {
        if (nums[start] * 2 > target || 2 * nums[end] < target) {
            return;
        }
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                result.add(Arrays.asList(first, second, nums[start], nums[end]));
                start++;
                end--;
                while (start < end && nums[start - 1] == nums[start]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end + 1]) {
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
