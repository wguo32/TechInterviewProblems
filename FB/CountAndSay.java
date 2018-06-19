class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        String str = "1";
        for (int i = 1; i < n; i++) {
            char pre = '#';
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                if (pre == '#' || pre == str.charAt(j)) {
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
