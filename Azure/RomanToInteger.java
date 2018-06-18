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

// no hashmap
class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int pre = getNum(s.charAt(0));
        int sum = pre;
        for (int i = 1; i < s.length(); i++) {
            int cur = getNum(s.charAt(i));
            sum += cur;
            if (cur > pre) {
                sum -= 2 * pre;
            }
            pre = cur;
        }
        return sum;
    }

    private int getNum(char c) {
        switch (c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return 0;
    }
}
