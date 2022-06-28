package graphs.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Problem: 210. Course Schedule II
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscourse-schedule-ii
 */
public class CourseScheduleII {

    HashSet<Integer> gVisited = new HashSet<>();
    ArrayList<Integer> list = new ArrayList<>();
    int[] order;
    int idx;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++)
            graph.put(i, new HashSet<>());

        for (int[] pre : prerequisites)
            graph.get(pre[0]).add(pre[1]);

        order = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            if (!gVisited.contains(i) && !dfs(graph, i, new HashSet<>()))
                return new int[0];
        return order;
    }

    public boolean dfs(HashMap<Integer, HashSet<Integer>> graph, int current, HashSet<Integer> visited) {
        if (visited.contains(current))
            return false;
        if (gVisited.contains(current))
            return true;

        visited.add(current);
        for (int pre : graph.get(current)) {
            if (!dfs(graph, pre, visited))
                return false;
        }
        visited.remove(current);
        graph.put(current, new HashSet<>());
        order[idx++] = current;
        gVisited.add(current);
        return true;
    }
}