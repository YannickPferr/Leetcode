package other.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem: 675. Cut Off Trees for Golf Event
 * Difficulty: Hard
 * Link: https://leetcode.com/problemscut-off-trees-for-golf-event
 */
public class CutOffTreesForGolfEvent {
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);
        for (List<Integer> l : forest)
            for (int num : l)
                if (num > 1)
                    heap.add(num);

        int count = 0;
        int currentI = 0;
        int currentJ = 0;
        while (!heap.isEmpty()) {
            int target = heap.poll();
            int[] result = shortestPath(forest, currentI, currentJ, target);
            if (result[0] == -1)
                return -1;
            count += result[0];
            currentI = result[1];
            currentJ = result[2];
        }

        return count;
    }

    public int[] shortestPath(List<List<Integer>> forest, int i, int j, int target) {
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        int pathLen = -1;
        int currI = i;
        int currJ = j;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] coordinates = q.poll();
                currI = coordinates[0];
                currJ = coordinates[1];
                int el = forest.get(currI).get(currJ);
                if (el == target)
                    return new int[]{pathLen + 1, currI, currJ};

                if (currI + 1 < forest.size() && !visited[currI + 1][currJ] && forest.get(currI + 1).get(currJ) >= 1) {
                    q.add(new int[]{currI + 1, currJ});
                    visited[currI + 1][currJ] = true;
                }
                if (currJ + 1 < forest.get(0).size() && !visited[currI][currJ + 1] && forest.get(currI).get(currJ + 1) >= 1) {
                    q.add(new int[]{currI, currJ + 1});
                    visited[currI][currJ + 1] = true;
                }
                if (currI - 1 >= 0 && !visited[currI - 1][currJ] && forest.get(currI - 1).get(currJ) >= 1) {
                    q.add(new int[]{currI - 1, currJ});
                    visited[currI - 1][currJ] = true;
                }
                if (currJ - 1 >= 0 && !visited[currI][currJ - 1] && forest.get(currI).get(currJ - 1) >= 1) {
                    q.add(new int[]{currI, currJ - 1});
                    visited[currI][currJ - 1] = true;
                }
            }
            pathLen++;
        }
        return new int[]{-1, currI, currJ};
    }
}