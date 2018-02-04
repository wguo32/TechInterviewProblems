class Solution {
    public String countAndSay(int n) {
        String result = "1";
        if (n <= 0) {
            return result;
        }

        for (int i = 1; i < n; i++) {
            result = buildStr(result);
        }
        return result;
    }

    private String buildStr(String result) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < result.length()) {
            char digit = result.charAt(index);
            int count = 0;
            while (index < result.length() && result.charAt(index) == digit) {
                    count++;
                    index++;
            }
            sb.append(String.valueOf(count));
            sb.append(digit);
        }
        return sb.toString();
    }
}
