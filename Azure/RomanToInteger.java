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

        int pre = map.get(s.charAt(0));
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            int cur = map.get(s.charAt(i));
            if (cur <= pre) {
                sum += pre;
            } else {
                sum -= pre;
            }
            pre = cur;
        }
        sum += pre;
        return sum;
    }
}
