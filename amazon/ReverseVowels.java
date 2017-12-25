class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int start = 0, end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (start < end) {
            while (start < end && !isVowel(chars[start])) {
                start++;
            }
            while (start < end && !isVowel(chars[end])) {
                end--;
            }
            if (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }

    public boolean isVowel(char c) {
        return "aeiouAEIOU".contains(c + "");
    }
}
