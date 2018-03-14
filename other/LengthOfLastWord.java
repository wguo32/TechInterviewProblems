// using methods from library
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return s.trim().length() - s.trim().lastIndexOf(" ")- 1;
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length(), wordLen = 0;
        while (len > 0 && s.charAt(len - 1) == ' ') {
            len--;
        }
        while (len > 0 && s.charAt(len - 1) != ' ') {
            wordLen++;
            len--;
        }
        return wordLen;
    }
}
