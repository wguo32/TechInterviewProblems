class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        Arrays.sort(nums);
        powerSet(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void powerSet(int[] nums, List<List<Integer>> result, ArrayList<Integer> list, int start) {
        result.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            powerSet(nums, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
