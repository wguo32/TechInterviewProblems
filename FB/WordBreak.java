class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();

        boolean[] canBreak = new boolean[len + 1];
        canBreak[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                // can break for the first j chars
                if (canBreak[j] && wordDict.contains(word)) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[len];
    }
}
