class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
        	return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
        	int mid = start + (end - start) / 2;
        	if (nums[mid] == target) {
        		return mid;
        	} else if (nums[mid] > nums[start]) {
        		if (target >= nums[start] && target <= nums[mid]) {
        			end = mid;
        		} else {
        			start = mid;
        		}
        	} else {
        		if (target >= nums[mid] &&  target <= nums[end]) {
        			start = mid;
        		} else {
        			end = mid;
        		}
        	}
        }

        if (target == nums[start]) {
        	return start;
        } else if (target == nums[end]) {
        	return end;
        } else {
        	return -1;
        }
    }
}
