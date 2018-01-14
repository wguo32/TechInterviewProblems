// time complexity O(N^2), space complexity O(k)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex < 0) {
            return result;
        }

        Integer[] array = new Integer[rowIndex + 1];
        Arrays.fill(array, 0);
        array[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                array[j] += array[j - 1];
            }
        }
        return Arrays.asList(array);
    }
}
