class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> keys = map.keySet();
            if (keys.contains(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result [1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
