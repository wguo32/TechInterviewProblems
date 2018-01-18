// use HashMap
class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toCharArray();
        int sum = 0;
        int pre = map.get(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (map.get(chars[i]) > pre) {
                sum -= pre;
            } else {
                sum += pre;
            }
            pre = map.get(chars[i]);
        }
        sum += pre;
        return sum;
    }
}

// no HashMap
class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int sum = convert(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            sum += convert(chars[i]);
            if (convert(chars[i - 1]) < convert(chars[i])) {
                sum -= 2 * convert(chars[i - 1]);
            }
        }
        return sum;
    }
    private int convert(char c) {
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
