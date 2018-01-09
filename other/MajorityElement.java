class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        Map.Entry<Integer, Integer> mEntry = null;
        // int maxCount = 1;
        // int maxKey =
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (mEntry == null || entry.getValue() > mEntry.getValue()) {
                    mEntry = entry;
            }
        }
        return mEntry.getKey();
    }
}
