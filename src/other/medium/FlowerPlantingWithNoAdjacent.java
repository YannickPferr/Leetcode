package other.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Problem: 1042. Flower Planting With No Adjacent
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsflower-planting-with-no-adjacent
 */
public class FlowerPlantingWithNoAdjacent {

    class Garden {
        int num;
        int flower;
        List<Garden> neighbors = new ArrayList<>();

        public Garden(int num) {
            this.num = num;
        }
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] out = new int[n];
        HashMap<Integer, Garden> gardens = new HashMap<>();
        for (int i = 1; i <= n; i++)
            gardens.put(i, new Garden(i));

        for (int[] path : paths) {
            int from = path[0];
            int to = path[1];
            gardens.get(from).neighbors.add(gardens.get(to));
            gardens.get(to).neighbors.add(gardens.get(from));
        }

        for (int i = 1; i <= n; i++) {
            Garden g = gardens.get(i);
            for (int flower = 1; flower <= 4; flower++) {
                boolean noNeighbor = true;
                for (Garden neighbor : g.neighbors) {
                    if (neighbor.flower == flower) {
                        noNeighbor = false;
                        break;
                    }
                }

                if (noNeighbor) {
                    g.flower = flower;
                    out[g.num - 1] = flower;
                    break;
                }
            }
        }
        return out;
    }
}