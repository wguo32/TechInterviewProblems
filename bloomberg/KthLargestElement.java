// using priority queue, time complexity O(nlogn), space complexity is O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}

// quick select, time complexity worse case O(N^2) and best case O(N)
// without constant extra space
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (true) {
            int pos = partition(left, right, nums);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }
    private int partition(int left, int right, int[] nums) {
        int pivot = nums[left];
        int start = left + 1;

        while (start <= right) {
            if (nums[start] < pivot && nums[right] > pivot) {
                swap(nums, start, right);
                start++;
                right--;
            }
            if (nums[start] >= pivot) {
                start++;
            }
            if (nums[right] <= pivot) {
                right--;
            }
        }
        swap(nums, left, right);
        return right;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
