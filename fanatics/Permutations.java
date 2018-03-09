class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        List<Integer> list = new ArrayList<>();
        helper(nums, 0, result, list);
        return result;
    }

    private void helper(int[] nums, int start, List<List<Integer>> result, List<Integer> list) {
        if (start == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            swap(nums, start, i);
            helper(nums, start + 1, result, list);
            list.remove(list.size() - 1);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
