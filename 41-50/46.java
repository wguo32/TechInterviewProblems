class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        findPermute(nums, new ArrayList<Integer>(), result);
        return result;
    }

    private void findPermute(int[] nums, List<Integer> list,
                            List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                findPermute(nums, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}
