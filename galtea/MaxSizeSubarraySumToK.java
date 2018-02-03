class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, - 1);

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                len = Math.max(len, (i - map.get(nums[i] - k)));
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return len;
    }
}
