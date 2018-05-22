/*
A matrix mat is given to find out all the numbers that appear in the row.
If there are multiple, return the minimum number . If not, return -1.
*/
public class Solution {
    /**
     * @param mat: The matrix
     * @return: The answer
     */
     public int findingNumber(int[][] mat) {
         Map<Integer, Integer> map = new HashMap<>();
         for (int i = 0; i < mat.length; i++) {
             for (int j = 0; j < mat[i].length; j++) {
                 if (map.containsKey(mat[i][j])) {
                     if (map.get(mat[i][j]) == i - 1) {
                         map.put(mat[i][j], i);
                     }
                 } else {
                     if (i == 0) {
                         map.put(mat[i][j], 0);
                     }
                 }
             }

             int minNum = Integer.MAX_VALUE;
             for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                 if (entry.getValue() == mat.length - 1) {
                     minNum = Math.min(minNum, entry.getKey());
                 }
             }
             return minNum == Integer.MAX_VALUE ? -1 : minNum;
         }
     }
 }
