class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        helper(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(int[] nums, int start, List<Integer> set, List<List<Integer>> result) {
        result.add(new ArrayList<>(set));

        for (int i = start; i < nums.length; i++) {
            set.add(nums[i]);
            helper(nums, i + 1, set, result);
            set.remove(set.size() - 1);
        }
    }
}
