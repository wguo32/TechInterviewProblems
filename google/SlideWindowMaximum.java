class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k - 1; i++) {
            push(deque, nums[i]);
        }
        int j = 0;
        for (int i = k - 1; i < nums.length; i++) {
            push(deque, nums[i]);
            result[j++] = deque.peekFirst();
            pop(deque, nums[i - (k - 1)]); // remove the first element in current window
        }
        return result;
    }

    private void push(Deque<Integer> deque, int num) {
        while (!deque.isEmpty() && deque.peekLast() < num) { // can't be equal
            deque.pollLast();
        }
        deque.offer(num);
    }

    private void pop(Deque<Integer> deque, int num) {
        if (deque.peekFirst() == num) {
            deque.pollFirst();
        }
    }
}
