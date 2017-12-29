import java.util.Queue;
import java.util.PriorityQueue;

public class ShortestJobFirst {
    class Job {
        int startTime;
        int duration;
        Job(int start, int duration) {
            this.startTime = start;
            this.duration = duration;
        }
    }
    public float averageWaitTime(int[] arriveTime, int[] duriations) {
        if (arriveTime == null || duriations == null ||
            arriveTime.length == 0 || durations.length == 0) {
            return 0;
        }

        Queue<Job> queue = new PriorityQueue<>(new Comparator<Job>(){
            public int compare(Job a, Job b) {
                if (a.duration < b.duration) {
                    return -1;
                }
                if (a.duration == b.duration) {
                    return a.startTime - b.startTime;
                }
                return 1;
            }
        });

        queue.offer(new Job(arriveTime[0], durations[0]));

        int wait = 0, current = durations[0], index = 0;
        while (!queue.isEmpty()) {
            Job job = queue.poll();
            wait += current - job.startTime;
            current += job.duration;
            while (index < arriveTime.length && arriteTime[index] < current) {
                queue.offer(new Job(arriveTime[index], durations[index]));
                index++;
            }
        }
        return (float)wait / arriveTime.length;
    }
}
