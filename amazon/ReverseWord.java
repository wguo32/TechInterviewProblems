class Solution {
    public void reverseWords(char[] str) {
        if (str == null || str.length == 0) {
            return;
        }

        // reverse the char array
        reverse(str, 0, str.length - 1);

        int start = 0, end = 0;
        while (end < str.length) {
            if (str[end] == ' ') {
                reverse(str, start, end - 1);
                start = end + 1;
            }
            end++;
        }

        // don't forget to reverse the last word
        // hello_word --> drow_olleh, the last word could not be detected with ' '
        reverse(str, start, str.length - 1);
    }

    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
