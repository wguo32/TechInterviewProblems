// with sorting and o(nlgn) time complexity
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int longest = 1;
        int curLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                if (nums[i] == nums[i - 1] + 1) {
                    curLen++;
                    longest = Math.max(longest, curLen);
                } else {
                    curLen = 1;
                }
            }
        }
        return longest;
    }
}

// o(n) time complexity with hashset
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int result = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            }
            int pre = num - 1;
            int next = num + 1;

            while (set.contains(pre)) {
                set.remove(pre);
                pre = pre - 1;
            }

            while (set.contains(next)) {
                set.remove(next);
                next = next + 1;
            }
            result = Math.max(result, next - pre - 1);
        }
        return result;
    }
}
