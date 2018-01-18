class Solution {
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     if (triangle == null || triangle.size() == 0) {
    //         return Integer.MAX_VALUE;
    //     }
    //     int minTotal = Integer.MAX_VALUE;
    //     return helper(triangle, 0, 0);
    // }
    //
    // private int helper(List<List<Integer>> triangle, int level, int index) {
    //     if (level == triangle.size()) {
    //         return 0;
    //     }
    //
    //     List<Integer> list = triangle.get(level);
    //     int min = Integer.MAX_VALUE;
    //     return list.get(index) +
    //             Math.min(helper(triangle, level + 1, index),
    //                     helper(triangle, level + 1, index + 1));
    // }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}
