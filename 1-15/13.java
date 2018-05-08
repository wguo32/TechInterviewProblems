class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int index = s.length() - 1;
        int pre = map.get(s.charAt(index));
        index--;
        int result = pre;
        while (index >= 0) {
            int cur = map.get(s.charAt(index));
            if (cur < pre) {
                result -= cur;
            } else {
                result += cur;
            }
            pre = cur;
            index--;
        }
        return result;
    }
}
