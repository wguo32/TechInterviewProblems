class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int closeSum = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i ==0 && nums[i - 1] != nums[i]) { // to skip duplicates
                int start = i + 1, end = nums.length - 1;
                while (start < end) {
                    int sum = nums[start] + nums[end] + nums[i];
                    if (Math.abs(target - sum) < Math.abs(target - closeSum)) {
                        closeSum = sum;
                    }
                    if (sum < target) {
                        start++;
                    } else if (sum == target) {
                        return sum;
                    } else {
                        end--;
                    }
                }
            }
        }
        return closeSum;
    }
}
