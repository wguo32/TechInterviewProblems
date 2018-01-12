// approach1: 2 for loops
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curr.set(j, 1);
                } else {
                    ArrayList<Integer> pre = list.get(i - 1);
                    curr.set(j, pre.get(j - 1) + pre.get(j));
                }
            }
            result.add(cur);
        }
        return result;
    }
}


// approach2 DP
class Solution {
    public List<List<Integer>> generate(int numRows) {
        
    }
}
