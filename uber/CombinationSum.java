class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        helper(candidates, target, result, list, 0);
        return result;
    }

    private void helper(int[] nums, int target, List<List<Integer>> result,
                        List<Integer> list, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (index >= nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (target < nums[i]) {
                break;
            }
            list.add(nums[i]);
            helper(nums, target - nums[i], result, list, i);
            list.remove(list.size() - 1);
        }
    }
}
