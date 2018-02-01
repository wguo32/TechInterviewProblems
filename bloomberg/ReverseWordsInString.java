public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        String[] substrings = s.trim().split("\\s+");
        for (int i = substrings.length - 1; i >= 0; i--) {
            sb.append(substrings[i] + " ");
        }
        return sb.toString().trim();
    }
}
