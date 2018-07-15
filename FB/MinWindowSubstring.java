class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        String result = "";
        int[] sArray = new int[256];
        int[] tArray = new int[256];

        for (char c : t.toCharArray()) {
            tArray[c]++;
        }

        int left = findNextStrIndex(s, tArray, 0);
        if (left == s.length()) {
            return result;
        }

        int right = left;
        int match = 0;
        while (right < s.length()) {
            int rightChar = (int)s.charAt(right);
            if (sArray[rightChar] < tArray[rightChar]) {
                match++;
            }
            sArray[rightChar]++;
            while (left < s.length() && match == t.length()) {
                if (result.isEmpty() || result.length() > right - left + 1) {
                    result = s.substring(left, right + 1);
                }

                int leftChar = (int)s.charAt(left);
                if (sArray[leftChar] <= tArray[leftChar]) {
                    match--;
                }
                sArray[leftChar]--;
                left = findNextStrIndex(s, tArray, left + 1);
            }
            right = findNextStrIndex(s, tArray, right + 1);
        }
        return result;
    }

    private int findNextStrIndex(String s, int[] tArray, int start) {
        while (start < s.length()) {
            char c = s.charAt(start);
            if (tArray[c] != 0) {
                return start;
            }
            start++;
        }
        return start;
    }
}
