package stack.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        Deque<Double> stack = new ArrayDeque<>();
        for (int i = 0; i < position.length; i++) {
            while (!stack.isEmpty() && cars[i][1] >= stack.peek())
                stack.pop();
            stack.push(cars[i][1]);
        }
        return stack.size();
    }
}