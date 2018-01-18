// bottom up approach
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int len = triangle.size();
        int[] arr = new int[len];
        int lastRow = triangle.get(len - 1);
        for (int i = 0; i < len; i++) {
            arr[i] = lastRow.get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                arr[j] = Math.min(arr[j], arr[j + 1]) + list.get(j);
            }
        }
        return arr[0];
    }
}
