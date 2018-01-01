/**
All the integers in the array are distinct
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        // Arrays.sort(nums); // no need to sort the array
        powerSet(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void powerSet(int[] nums, List<List<Integer>> result, ArrayList<Integer> set, int start) {
        result.add(new ArrayList<>(set));

        for (int i = start; i < nums.length; i++) {
            set.add(nums[i]);
            powerSet(nums, result, set, i + 1);
            set.remove(set.size() - 1);
        }
    }
}
