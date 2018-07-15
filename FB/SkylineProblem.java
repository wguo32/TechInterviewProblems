// using priority queue
class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();

        // sweep the buildings
        for (int[] building : buildings) {
            heights.add(new int[] {building[0], -building[2]});
            heights.add(new int[] {building[1], building[2]});
        }
        // sort the points
        Collections.sort(heights, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        queue.offer(0);
        int pre = 0;
        for (int[] height : heights) {
            if (height[1] < 0) {
                queue.offer(-height[1]);
            } else {
                queue.remove(height[1]);
            }

            int cur = queue.peek();
            if (pre != cur) {
                result.add(new int[] {height[0], cur});
                pre = cur;
            }
        }
        return result;
    }
}
