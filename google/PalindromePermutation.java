class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int[] hash = new int[256];
        for (char c : s.toCharArray()) {
            hash[c]++;
        }
        int count = 0;
        for (int num : hash) {
            if (num % 2 == 1) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
