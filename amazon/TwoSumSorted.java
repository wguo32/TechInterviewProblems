class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 1) {
            return new int[] {-1, -1};
        }
        int i = 0, j = numbers.length - 1;
        while (j > i) {
            if (numbers[i] + numbers[j] == target) {
                return new int[] {i + 1, j + 1};
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[] {};
    }
}
