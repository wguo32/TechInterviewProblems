// prefered if add is used more
class TwoSum {
    List<Integer> list;
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
            list.add(number);
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++) {
            int num1 = list.get(i);
            int num2 = value - num1;
            if ((num1 == num2 && map.get(num1) > 1) ||
                (num1 != num2 && map.containsKey(num2))) {
                return true;
            }
        }
        return false;
    }
}

// prefered if find is used more, but this is TLE
    Set<Integer> sums;
    Set<Integer> nums;
    /** Initialize your data structure here. */
    public TwoSum() {
        sums = new HashSet<>();
        nums = new HashSet<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (nums.contains(number)) {
            sums.add(2 * number);
        } else {
            Iterator<Integer> it = nums.iterator();
            while (it.hasNext()) {
                sums.add(it.next() + number);
            }
            nums.add(number);
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        return sums.contains(value);
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
