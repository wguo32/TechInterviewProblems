class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] breakable = new boolean[len + 1];
        breakable[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                String substr = s.substring(j, i);
                if (breakable[j] && wordDict.contains(substr)) {
                    breakable[i] = true;
                    break;
                }
            }
        }
        return breakable[len];
    }
}
