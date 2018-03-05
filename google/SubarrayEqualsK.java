class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] presum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }

        int count = 0;
        for (int i = 1; i < len + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (presum[i] - presum[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}

// no extra space needed
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}

// linear time using hashmap
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        int count = 0;

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
