package heap.medium;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Problem: 621. Task Scheduler
 * Difficulty: Medium
 * Link: https://leetcode.com/problemstask-scheduler
 */
public class TaskScheduler {

    class Task {
        public int count;
        public int lastUsed = -1;

        public Task(int count) {
            this.count = count;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Task> heap = new PriorityQueue<>((t1, t2) -> t2.count - t1.count);
        int[] count = new int[26];
        for (char c : tasks)
            count[c - 'A']++;
        for (int i = 0; i < count.length; i++)
            if (count[i] > 0)
                heap.add(new Task(count[i]));

        LinkedList<Task> q = new LinkedList<>();
        int timeStep = 0;
        while (!heap.isEmpty() || !q.isEmpty()) {
            if (!q.isEmpty() && (q.peek().lastUsed == -1 || timeStep - q.peek().lastUsed > n))
                heap.add(q.poll());

            if (!heap.isEmpty()) {
                Task t = heap.poll();
                t.count--;
                t.lastUsed = timeStep;
                if (t.count > 0)
                    q.add(t);
            }
            timeStep++;
        }

        return timeStep;
    }
}