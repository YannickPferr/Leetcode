package other.easy;

import java.util.HashSet;

/**
 * Problem: 575. Distribute Candies
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsdistribute-candies
 */
public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> uniqueCandies = new HashSet<>();
        for (int candy : candyType) {
            uniqueCandies.add(candy);
            if (uniqueCandies.size() == candyType.length / 2)
                return uniqueCandies.size();
        }


        return uniqueCandies.size();
    }
}