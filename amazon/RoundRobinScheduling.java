import java.util.LinkedList;
import java.util.Queue;

class Task {
    int startTime;
    int waiting;
    Task(int start, int waiting) {
        this.startTime = start;
        this.waiting = waiting;
    }
}
public class RoundRobinScheduling {
    public float averageWaitTime(int[] startTimes, int[] waitings, int quantum) {
        if (startTimes == null || waitings == null ||
            startTimes.length == 0 || waitings.length == 0) {
            return 0;
        }

        Queue<Task> queue = new LinkedList<>();
        queue.offer(new Task(startTimes[0], waitings[0]));

        int wait = 0, current = 0;
        int index = 1, len = startTimes.length;
        while (!queue.isEmpty()) {
            Task task = queue.poll();
            current += task.waiting > quantum ? quantum : task.waiting;
            wait += current - task.startTime;
            while (index < len && startTimes[index] < current) {
                queue.offer(new Task(startTimes[index], waitings[index]));
                index++;
            }
            if (current < task.startTime + task.waiting) {
                queue.offer(new Task(current, task.waiting - quantum));
            }
        }
        return (float)wait / len;
    }

    public static void main(String args[]) {
        RoundRobinScheduling rrs = new RoundRobinScheduling();
        int[] starts = {0,0,0};
        int[] waitings = {10, 5, 8};
        int quantum = 2;
        float wait = rrs.averageWaitTime(starts,waitings, quantum);
        System.out.println("Waiting time is " + wait);
    }
}
