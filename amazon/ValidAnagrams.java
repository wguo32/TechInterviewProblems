class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] hash = new int[256];
        for (char c : t.toCharArray()) {
            hash[c]++;
        }

        for (char c : s.toCharArray()) {
            hash[c]--;
        }

        for (int num : hash) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
