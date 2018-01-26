class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int i = 0, index =0, len = chars.length;
        while (i < len) {
            char cur = chars[i];
            int count = 0;
            while (i < len && chars[i] == cur) {
                i++;
                count++;
            }
            chars[index++] = cur;
            if (count != 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }
        return index;
    }
}
