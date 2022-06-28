package graphs.medium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Problem: 207. Course Schedule
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscourse-schedule
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++)
            graph.put(i, new HashSet<>());

        for (int[] p : prerequisites)
            graph.get(p[0]).add(p[1]);

        for (int i = 0; i < numCourses; i++)
            if (!dfs(graph, i, new HashSet<>()))
                return false;
        return true;
    }

    public boolean dfs(HashMap<Integer, HashSet<Integer>> graph, int current, HashSet<Integer> visited) {
        if (visited.contains(current))
            return false;

        HashSet<Integer> pres = graph.get(current);
        visited.add(current);
        if (!pres.isEmpty())
            for (int pre : pres)
                if (!dfs(graph, pre, visited))
                    return false;
        graph.put(current, new HashSet<>());
        visited.remove(current);
        return true;
    }
}
