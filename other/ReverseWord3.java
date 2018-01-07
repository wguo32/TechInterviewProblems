class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder subsb = new StringBuilder(words[i]);
            subsb.reverse();
            subsb.append(" ");
            sb.append(subsb);
        }
        return sb.toString().trim();
    }
}
