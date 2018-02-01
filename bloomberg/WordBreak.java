class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }

        int len = s.length();
        boolean[] breakable = new boolean[len +1];
        breakable[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                String substr = s.substring(j, i);
                if (set.contains(substr) && breakable[j]) {
                    breakable[i] = true;
                    break;
                }
            }
        }
        return breakable[len];
    }
}
