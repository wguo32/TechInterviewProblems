class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(num)) {
                return new int[]{hash.get(nums[i]), i};
            } else {
                hash.put(i, target - nums[i]);
            }
        }
    }
}
