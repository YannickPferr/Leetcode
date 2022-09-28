package other.medium;

import java.util.PriorityQueue;

/**
 * Problem: 1882. Process Tasks Using Servers
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsprocess-tasks-using-servers
 */
public class ProcessTasksUsingServers {
    class Server {
        int server;
        int weight;
        int free = 0;

        public Server(int server, int weight) {
            this.server = server;
            this.weight = weight;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] arr = new int[tasks.length];
        PriorityQueue<Server> free = new PriorityQueue<>((a, b) -> a.weight == b.weight ? a.server - b.server : a.weight - b.weight);
        PriorityQueue<Server> blocked = new PriorityQueue<>((a, b) -> a.free == b.free ? (a.weight == b.weight ? a.server - b.server : a.weight - b.weight) : a.free - b.free);
        for (int i = 0; i < servers.length; i++)
            free.add(new Server(i, servers[i]));

        for (int i = 0; i < tasks.length; i++) {
            while (!blocked.isEmpty() && i >= blocked.peek().free)
                free.add(blocked.poll());

            Server s = null;
            if (!free.isEmpty()) {
                s = free.poll();
                s.free = i + tasks[i];
            } else {
                s = blocked.poll();
                s.free += tasks[i];
            }
            arr[i] = s.server;
            blocked.add(s);
        }

        return arr;
    }
}