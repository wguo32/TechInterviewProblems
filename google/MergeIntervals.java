/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 //  use java8 lambda expression for comparision
 // Lambda expression facilitates functional programming, and simplifies the development a lot
 class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return new List<Interval>();
        }

        List<Interval> result = new ArrayList<Interval>();
        intervals.sort(Comparator.comparing(i -> i.start));

        Interval pre = null;
        for (Interval interval : intervals) {
            if (pre == null || pre.end < interval.start) {
                result.add(interval);
                pre = interval;
            } else {
                pre.end = Math.max(pre.end, interval.end);
            }
        }
        return result;
    }
}
