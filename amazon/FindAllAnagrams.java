class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int[] hash = new int[256];
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        int needCount = p.length();
        int start = 0, end = 0;
        while (end < s.length()) {
            if (hash[s.charAt(end)] >= 1) { // if it is 0, it means we don't need this character
                needCount--;
            }
            hash[s.charAt(end)]--;
            end++;

            if (needCount == 0) {
                result.add(start);
            }
            if (end - start == p.length()) {
                if (hash[s.charAt(start)] >= 0) {
                    needCount++;
                }
                hash[s.charAt(start)]++;
                start++;
            }
        }
        return result;
    }
}
