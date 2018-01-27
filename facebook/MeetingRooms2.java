/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int i = 1, j = 0, rooms = 1, count = 1;
        while (i < intervals.length && j < intervals.length) {
            if (starts[i] < ends[j]) {
                rooms++;
                i++;
                if (rooms > count) {
                    count = rooms;
                }
            } else {
                rooms--;
                j++;
            }
        }
        return count;
    }
}
