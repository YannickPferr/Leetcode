package greedy.medium;

/**
 * Problem: 1899. Merge Triplets to Form Target Triplet
 * Difficulty: Medium
 * Link: https://leetcode.com/problemsmerge-triplets-to-form-target-triplet
 */
public class MergeTripletsToFormTargetTriplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] greedy = new boolean[3];
        loop:
        for (int[] triplet : triplets) {
            for (int i = 0; i < 3; i++)
                if (triplet[i] > target[i])
                    continue loop;

            for (int i = 0; i < 3; i++)
                if (triplet[i] == target[i])
                    greedy[i] = true;
        }

        return greedy[0] && greedy[1] && greedy[2];
    }
}