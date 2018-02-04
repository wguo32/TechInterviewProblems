class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();

        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(chars[i])) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(chars[j])) {
                j--;
            }
            if (i < j) {
                if (Character.toLowerCase(chars[i]) != Character.toLowerCase(chars[j])) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return true;
    }
}
