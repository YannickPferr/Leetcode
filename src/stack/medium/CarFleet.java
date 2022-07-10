package stack.medium;

import java.util.Arrays;

/**
 * Problem: 853. Car Fleet
 * Difficulty: Medium
 * Link: https://leetcode.com/problemscar-fleet
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];
        for (int i = 0; i < position.length; i++)
            cars[i] = new double[]{position[i], (target - position[i]) / (double) speed[i]};
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        double prev = -1;
        int fleet = 0;
        for (double[] car : cars) {
            if (prev == -1 || car[1] > prev) {
                fleet++;
                prev = car[1];
            }
        }

        return fleet;
    }
}