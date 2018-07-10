// o(nlgn) time complexity for sorting
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        if (nums[0] != 0) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                return nums[i - 1] + 1;
            }
        }
        return -1;
    }
}

// hashset with linear time complexity
class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i < nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
