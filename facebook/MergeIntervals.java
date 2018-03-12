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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        intervals.sort(Comparator.comparing(i -> i.start));
        Interval pre = null;
        for(Interval i : intervals) {
            if (pre == null || pre.end < i.start) {
                result.add(i);
                pre = i;
            } else {
                pre.end = Math.max(pre.end, i.end);
            }
        }
        return result;
    }
}
