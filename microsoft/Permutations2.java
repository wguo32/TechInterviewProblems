class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        boolean[] used = new boolean[nums.length];
        helper(nums, used, result, new ArrayList<Integer>());
        return result;
    }

    private void helper(int[] nums, boolean[] used,
                        List<List<Integer>> result, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            helper(nums, used, result, list);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}

// the following code does not work!
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        helper(nums, 0, list, result);
        return result;
    }

    private void helper(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {
        if (start >= nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (start > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            swap(nums, start, i);
            helper(nums, start + 1, list, result);
            list.remove(list.size() - 1);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Permutations2 p2 = new Permutations2();
        int[] arr = {1,2,3};
        List<List<Integer>> result = p2.permuteUnique(arr);
        System.out.println("++++++++++++++");
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            System.out.println("\nThe " + i + "th list:");
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + " ");
            }
        }
    }
}
