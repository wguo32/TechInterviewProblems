class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> hash = new HashMap<>();
        for (String str : strs) {
            char[] charArray= Arrays.sort(str.toCharArray());
            String sortedStr = String.valueOf(charArray);

            if (!hash.containsKey(sortedStr)) {
                hash.put(sortedStr, new ArrayList<>());
            }
                hash.put(sortedStr, hash.get(sortedStr).add(str));
            }
        }
        return new ArrayList(hash.values());
    }
}
