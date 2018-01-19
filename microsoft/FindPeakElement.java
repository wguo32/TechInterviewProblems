// original solution
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] < nums[1] ? 1 : 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length -1;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}

// linear search with less code
class Solution {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
}

// binary search
class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0,  end = nums.length - 1;
        while (start + 1  < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] < nums[end]) {
            return end;
        } else {
            return start;
        }
    }
}
