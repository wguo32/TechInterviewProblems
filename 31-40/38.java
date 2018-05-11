class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        String str = "1";
        for (int i = 1; i < n; i++) {
            int count = 0;
            char pre = '.';
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                if (pre == '.' || str.charAt(j) == pre) {
                    count++;
                } else {
                    sb.append(count + Character.toString(pre));
                    count = 1;
                }
                pre = str.charAt(j);
            }
            sb.append(count + Character.toString(pre));
            str = sb.toString();
        }
        return str;
    }
}
