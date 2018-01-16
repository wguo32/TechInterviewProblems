// HashMap
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if (map.get(num) > nums.length / 2) {
                result = num;
                break;
            }
        }
        return result;
        // Map.Entry<Integer, Integer> mEntry = null;
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     if (mEntry == null || entry.getValue() > mEntry.getValue()) {
        //             mEntry = entry;
        //     }
        // }
        // return mEntry.getKey();
    }
}

// Boyer-Moore Voting Algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer major = null;
        for (int num : nums) {
            if (count == 0) {
                major = num;
            }
            count += (major == num ? 1 : -1);
        }
        return major;
    }
}
