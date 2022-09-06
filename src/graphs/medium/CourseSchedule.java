package graphs.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Problem: 207. Course Schedule
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscourse-schedule
 */
public class CourseSchedule {
    boolean[] globalVisited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] arr : prerequisites) {
            List<Integer> pres = graph.getOrDefault(arr[1], new ArrayList<>());
            pres.add(arr[0]);
            graph.put(arr[1], pres);
        }

        globalVisited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++)
            if (!globalVisited[i] && !dfs(graph, i, new boolean[numCourses]))
                return false;
        return true;
    }

    public boolean dfs(HashMap<Integer, List<Integer>> graph, int course, boolean[] cycle) {
        if (cycle[course])
            return false;

        cycle[course] = true;
        List<Integer> pres = graph.getOrDefault(course, new ArrayList<>());
        for (int pre : pres)
            if (!globalVisited[pre] && !dfs(graph, pre, cycle))
                return false;

        globalVisited[course] = true;
        return true;
    }
}