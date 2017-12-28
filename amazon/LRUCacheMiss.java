import java.util.LinkedList;
import java.util.List;
public class LRUCacheMiss {
    public int countMiss (int[] nums, int size) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        List<Integer> cache = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (cache.contains(new Integer(nums[i]))) {
                cache.remove(nums[i]);
            } else {
                count++;
                if (cache.size() == size) {
                    cache.remove(0);//remove(int index)
                }
            }
            cache.add(nums[i]);
        }
        return count;
    }
    public static void main(String args[]) {
        LRUCacheMiss cacheMiss = new LRUCacheMiss();
        int[] nums = new int[] {1,2,3,4,5,6,1};
        System.out.println(cacheMiss.countMiss(nums, 5));
    }
}
