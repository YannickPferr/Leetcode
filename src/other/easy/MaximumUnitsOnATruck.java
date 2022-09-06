package other.easy;

/**
 * Problem: 1710. Maximum Units on a Truck
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsmaximum-units-on-a-truck
 */
public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] count = new int[1001];
        for (int[] box : boxTypes)
            count[box[1]] += box[0];

        int max = 0;
        int numBoxes = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            int[] box = new int[]{count[i], i};
            int boxNum = box[0];
            for (int j = 0; j < boxNum; j++) {
                if (numBoxes + 1 > truckSize)
                    return max;
                max += box[1];
                numBoxes++;
            }
        }
        return max;
    }
}