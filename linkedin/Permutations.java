class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        helper(nums, new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(int[] nums, ArrayList<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
                helper(nums, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}
