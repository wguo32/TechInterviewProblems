class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        final Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int count = words.length;
        int len = words[0].length();
        for (int i = 0; i <= s.length() - len * count; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            int j = count;
            int start = i;
            while(j > 0) {
                String str = s.substring(start, start + len);
                if (!copy.containsKey(str) || copy.get(str) < 1) {
                    break;
                }
                copy.put(str, copy.get(str) - 1);
                j--;
                start += len;
            }
            if (j == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
