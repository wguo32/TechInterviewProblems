class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k - 1; i++) {
            pushDeque(deque, nums[i]);
        }

        int j = 0;
        for (int i = k - 1; i < nums.length; i++) {
            pushDeque(deque, nums[i]);
            result[j++] = deque.peekFirst();
            popDeque(deque, nums[i - (k - 1)]);
            // pushDeque(deque, nums[i]);
        }
        return result;
    }

    public void pushDeque(Deque<Integer> deque, int number) {
        while (!deque.isEmpty() && deque.peekLast() < number){
            deque.pollLast();
        }
        deque.offer(number);
    }

    public void popDeque(Deque<Integer> deque, int number) {
        if (deque.peekFirst() == number) {
            deque.pollFirst();
        }
    }
}
