package other.medium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Problem: 1042. Flower Planting With No Adjacent
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsflower-planting-with-no-adjacent
 */
public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] flowers = new int[n];
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        for (int[] path : paths) {
            HashSet<Integer> hs1 = hm.getOrDefault(path[0], new HashSet<>());
            hs1.add(path[1]);
            HashSet<Integer> hs2 = hm.getOrDefault(path[1], new HashSet<>());
            hs2.add(path[0]);
            hm.put(path[0], hs1);
            hm.put(path[1], hs2);
        }

        for (int garden = 1; garden <= n; garden++) {
            HashSet<Integer> adjacentFlowers = new HashSet<>();
            for (int neighbor : hm.getOrDefault(garden, new HashSet<>()))
                adjacentFlowers.add(flowers[neighbor - 1]);

            for (int flower = 1; flower <= 4; flower++) {
                if (!adjacentFlowers.contains(flower)) {
                    flowers[garden - 1] = flower;
                    break;
                }
            }

            flowers[garden - 1] = flowers[garden - 1] == 0 ? 1 : flowers[garden - 1];
        }

        return flowers;
    }

}