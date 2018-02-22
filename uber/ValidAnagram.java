// sorting
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        for (int i = 0; i < s.length(); i++) {
            if (charS[i] != charT[i]) {
                return false;
            }
        }
        return true;
    }
}

// use hashtable
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] table = new int[256];
        for (char c : s.toCharArray()) {
            table[c]++;
        }
        for (char c : t.toCharArray()) {
            table[c]--;
        }

        for (int num : table) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
