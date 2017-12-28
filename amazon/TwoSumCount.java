/**
It also works if the input array has duplicates, for example {1,1,3,7,8,8,9,10,10} target = 11
1(0)+10(0), 1(1)+10(0), 1(1)+10(0), 1(1)+10(1), 3+8(0), 3+8(1)
so there are 6 different pairs.
*/
public class Solution {
    public int twoSumCount (int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int count = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hash.containsKey(target - arr[i])) {
                count += hash.get(target - arr[i]);
            }
            if (!hash.containsKey(arr[i])) {
                hash.put(arr[i], 0);
            }
            hash.put(arr[i], hash.get(arr[i] + 1));
        }
    }
}
