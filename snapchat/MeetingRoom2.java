/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 // greedy method, time complexity O(NlogN)
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b)  -> a.start - b.start);

        // the top of minHeap is the interval with earlist end time
        Queue<Interval> minHeap = new PriorityQueue<>(intervals.length,
                                    (a, b) -> a.end - b.end);
        minHeap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval top = minHeap.poll();
            if (intervals[i].start < top.end) {
                minHeap.offer(intervals[i]);
            } else {
                top.end = intervals[i].end;
            }
            minHeap.offer(top);
        }
        return minHeap.size();
    }
}

/* sweep line, time complexity O(NlogN)
    intuition:
    if the current start time is earlier than earlist end time(which is indexed by the endIndex),
    then the earlist ending interval has not end yet, so a new room must be allocated.
    Otherwise, the meeting represented by current iterval can reuse the room which has been used by the interval
    with earlist ending time. In this case, that room is allocated to current interval, we NEED TO UPDATE the earlist
    end time, so once the interval with this new earlist end time end, other intervals can reuse the room.
*/
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < interval.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int num = 0;
        int endIndex = 0;
        for (int i = 0; i < starts.length; i++) {
            if (start[i] < ends[endIndex]) {
                num++;
            } else {
                endIndex++;
            }
        }
        return num;
    }
}
