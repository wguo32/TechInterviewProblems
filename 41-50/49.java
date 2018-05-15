class Solution {
   public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> result = new ArrayList<>();
       if (strs == null || strs.length == 0) {
           return result;
       }

       Map<String, ArrayList<String>> map = new HashMap<>();
       for (String str : strs) {
           char[] chars = str.toCharArray();
           Arrays.sort(chars);
           String sortStr = String.valueOf(chars);
           if (!map.containsKey(sortStr)) {
               map.put(sortStr, new ArrayList<String>());
           }
           ArrayList<String> list = map.get(sortStr);
           list.add(str);
           map.put(sortStr, list);
       }
       return new ArrayList<>(map.values());
   }
}
