/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

 // focus on the starting index, stop checking once iterating all startings
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
         int num = 0;
         int endP = 0;
         for (int i = 0; i < intervals.length; i++) {
             if (starts[i] < ends[endP]) {
                 num++;
             } else {
                 endP++;
             }
         }
         return num;
     }
 }
